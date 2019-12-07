package com.lmc.shopleasing.filter;

import com.lmc.shopleasing.service.SysUserService;
import com.lmc.shopleasing.util.JwtTokenUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Description:token的拦截器
 * @author huangweicheng
 * @date 2019/10/24   
*/
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    @Value("${jwt.header}")
    private String tokenHeader;

    private static final String ORIGIN ="Origin";

    private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private SysUserService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
//        if(StringUtils.isNotBlank(request.getHeader(ORIGIN))){
//            String origin = request.getHeader(ORIGIN);
//            response.addHeader("Access-Control-Allow-Origin",origin);
//            response.addHeader("Access-Control-Allow-Methods" ,"*");
//            response.addHeader("Access-Control-Allow-Credentials","true");
//            response.addHeader("Access-Control-Allow-Headers" ,"*");
//        }
//        if(StringUtils.equals("OPTIONS",request.getMethod())){
//            response.getWriter().print("OK");
//            response.getWriter().flush();
//            return;
//        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = request.getHeader(this.tokenHeader);
        if (token != null && (authentication == null || trustResolver.isAnonymous(authentication))) {
            if (jwtTokenUtil.validateToken(token))
            {
                String role = jwtTokenUtil.getRolesFromToken(token);
                String[] roles = role.split(",");
                List<GrantedAuthority> authorityList = new ArrayList<>();
                for (String r : roles)
                {
                    authorityList.add(new SimpleGrantedAuthority(r));
                }
                String username = jwtTokenUtil.getUserNameFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, authorityList);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                /*权限设置*/
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}