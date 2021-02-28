package com.platzi.marken.web.security.filter;

import com.platzi.marken.domain.service.UserDetalleService;
import com.platzi.marken.web.security.JWTUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    @Autowired
    private JWTUntil jwtUntil;

    @Autowired
    private UserDetalleService userDetalleService;

     @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            String jwt = authorizationHeader.substring(7);
            String username = jwtUntil.extractUsername(jwt);

            //Valida si el usuario esta autenicado
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null ){}
                UserDetails userDetails = userDetalleService.loadUserByUsername(username);

            //Valido Token
            if (jwtUntil.valideToken(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //Autenticamos
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }

        }
        //Validamos el filtro
        filterChain.doFilter(request, response);
    }

}
