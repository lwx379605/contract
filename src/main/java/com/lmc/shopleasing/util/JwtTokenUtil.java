package com.lmc.shopleasing.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Description: token相关的工具类
*/
@Component
public class JwtTokenUtil implements Serializable
{
    private static final long serialVersionUID = -4324967L;

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    private static final String CLAIM_KEY_ROLES = "roles";

    @Autowired
    private CacheManager cacheManager;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Integer expiration;

    /** 
     * 
     * Description: 解析token，从token中获取信息
     * @param token
    */
    private Claims getClaimsFromToken(String token)
    {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            System.err.println(e.getMessage());
            claims = null;
        }
        return claims;
    }
    
    /** 
     * 
     * Description:获取用户名
     * @param token
    */
    public String getUserNameFromToken(String token)
    {
        String userName;
        try {
            final Claims claims = getClaimsFromToken(token);
            userName = claims.getSubject();
        }catch (Exception e){
            userName = null;
        }
        return userName;
    }
    
    /** 
     * 
     * Description:从token中获取
     * @param token
    */
    public String getRolesFromToken(String token)
    {
        String roles;
        try {
            final Claims claims =  getClaimsFromToken(token);
            roles = (String) claims.get(CLAIM_KEY_ROLES);
        }catch (Exception e){
            roles = null;
        }
        return roles;
    }
    /** 
     * 
     * Description:获取token创建时间
     * @param token
    */
    public Date getCreatedDateFromToken(String token)
    {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        }catch (Exception e){
            created = null;
        }
        return created;
    }
    
    /** 
     * 
     * Description: 获取token过期时间
     * @param token
     * @author huangweicheng
     * @date 2019/10/23   
    */ 
    public Date getExpirationDateFromToken(String token)
    {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        }catch (Exception e){
            expiration = null;
        }
        return expiration;
    }
    
    /**
     *
     * Description:token生成过期时间
    */
    private Date generateExpirationDate()
    {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /** 
     * 
     * Description:token是否过期
     * @param token
     * @author huangweicheng
     * @date 2019/10/23   
    */ 
    private Boolean isTokenExpired(String token)
    {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    
    /** 
     * 
     * Description:token创建时间与密码最后修改时间比较，小于返回true，大于返回false
     * @param created
     * @param lastPasswordReset
    */
    private Boolean isCreatedBeforeLastPasswordReset(Date created,Date lastPasswordReset)
    {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }
    /** 
     * 
     * Description: 创建token
     * @param userDetails
    */
    public String generateToken(UserDetails userDetails)
    {
        String roles = "";
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        for (GrantedAuthority authority : authorities)
        {
            String temp = authority.getAuthority() + ",";
            roles += temp;
        }
        roles = roles.substring(0,roles.length() - 1);
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        claims.put(CLAIM_KEY_ROLES,roles);
        return generateToken(claims);
    }
    /** 
     * 
     * Description:使用Rs256签名
     * @param claims
    */
    private String generateToken(Map<String,Object> claims)
    {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    
    /** 
     * 
     * Description:是否刷新token
     * @param token
     * @param lastPasswordReset
    */
    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }
    
    /** 
     * 
     * Description:刷新token
     * @param token
    */
    public String refreshToken(String token)
    {
        String refreshToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED,new Date());
            refreshToken = generateToken(claims);
        }catch (Exception e){
            refreshToken = null;
        }
        return refreshToken;
    }

    /**
     *
     * Description:验证token
     * @param token
    */
    public boolean validateToken(String token) {
        Cache jwtCache = cacheManager.getCache("jwt");
        final String username = getUserNameFromToken(token);
        if (jwtCache.isKeyInCache(username)) {
            //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
//            Element element = jwtCache.get(username);
//            element.setTimeToIdle(expiration);
            return true;
        }
        return false;
    }
}