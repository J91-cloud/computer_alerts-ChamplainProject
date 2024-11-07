package com.calerts.computer_alertsbe.AuthDomain.system;

import com.webapp.computer_alerts.AuthDomain.businessLayer.AuthService;
import com.webapp.computer_alerts.AuthDomain.data.UserResponseModel;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Extract token from Authorization header
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // Remove "Bearer " prefix

            // Extract and map roles or other claims from the token as necessary
            List<SimpleGrantedAuthority> authorities = extractAuthoritiesFromToken(token);

            // Set up the authentication context
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken("user", null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private List<SimpleGrantedAuthority> extractAuthoritiesFromToken(String token) {
        // Custom logic to extract roles from the JWT and map to authorities
        // Example:
        return List.of(new SimpleGrantedAuthority("ROLE_Admin"));
    }
}

