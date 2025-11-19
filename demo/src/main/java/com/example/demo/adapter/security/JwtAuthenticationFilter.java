package com.example.demo.adapter.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.demo.config.JwtUtil;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;   // Tu clase que genera/valida tokens

    @Autowired
    private UserDetailsService userDetailsService; // Tu servicio de usuarios

    @Override
    protected void doFilterInternal(
            @SuppressWarnings("null") HttpServletRequest request,
            @SuppressWarnings("null") HttpServletResponse response,
            @SuppressWarnings("null") FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        // 1. Validar si viene el token en la cabecera
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwtToken = authHeader.substring(7);
            username = jwtUtil.extractUsername(jwtToken);
        }

        // 2. Si el usuario NO está autenticado aún
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 3. Validar token
            if (jwtUtil.isTokenValid(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                // 4. Establecer autenticación en el contexto
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // 5. Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}