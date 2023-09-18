package com.marcdev.rent_v3.handlerException;

import com.marcdev.rent_v3.configuration.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.ArrayList;


public class AuthorizationFilter extends BasicAuthenticationFilter {

    private final HandlerExceptionResolver exceptionResolver;
    public AuthorizationFilter(AuthenticationManager authenticationManager,
                               HandlerExceptionResolver exceptionResolver) {
        super(authenticationManager);

        this.exceptionResolver = exceptionResolver;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain)throws IOException, ServletException {
        String authorizationHeader = request.getHeader("authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")){
            chain.doFilter(request, response);
            return;
        }
        try {
            UsernamePasswordAuthenticationToken authentication = getAuthenticationToken(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
            System.out.println(" authorization fliter");
        }catch (ExpiredJwtException e){
            exceptionResolver.resolveException(request, response, null, e);
        }
    }
    JwtService jwtService;
    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if (token != null){
            token = token.replace("Bearer ", "");

            String username = jwtService.extractUsername(token);

            if (username != null){
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }
        }
        return null;
    }

}
