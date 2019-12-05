package com.lmc.shopleasing.filter;

import com.lmc.shopleasing.service.SysUserService;
import com.lmc.shopleasing.util.JwtTokenUtil;
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

    private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private SysUserService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = httpServletRequest.getHeader(this.tokenHeader);
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
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                /*权限设置*/
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}