package com.example.democarcrud.configurations;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Enumeration;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader=request.getHeader("Authorization");
        final String jwt;
        final String userName;

        //************************************************************

        HttpServletRequest requests = (HttpServletRequest) request;
        String requestURI = requests.getRequestURI();
        String method = requests.getMethod();
        String queryString = requests.getQueryString();
        String contentType = requests.getContentType();
        String remoteAddr = requests.getRemoteAddr();
        String remoteHost = requests.getRemoteHost();
        int remotePort = requests.getRemotePort();
        String userAgent = requests.getHeader("User-Agent");

        logger.info("Incoming request: {} {} [{}] from {}:{} ({}) [{}]", method, requestURI, queryString, remoteAddr, remotePort, remoteHost, contentType, userAgent);




        //************************************************************
        //early break if there is no token
        if(authHeader==null||!authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        //if there is a token we do the following
        jwt = authHeader.substring(7);//get the token
        userName = jwtService.getUserName(jwt);//get the username for the token
        System.out.println("hello4");
        if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){//there is a username and he is not authenticated
            //detect if the details of the user are correct
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
            if(jwtService.tokenValid(jwt,userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        }
        filterChain.doFilter(request, response);
    }
}
