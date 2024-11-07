package com.calerts.computer_alertsbe.AuthDomain.businessLayer;


import com.webapp.computer_alerts.AuthDomain.data.UserDetails;
import com.webapp.computer_alerts.AuthDomain.system.JwtVerifier;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtVerifier jwtVerifier;

    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(JwtVerifier jwtVerifier, AuthenticationManager authenticationManager) {
        this.jwtVerifier = jwtVerifier;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(String username, String password) {
        // Authenticate the user using the AuthenticationManager
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // Extract the user's roles from the authentication object
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        // Generate the JWT token
        return jwtVerifier.generateToken(new UserDetails(username, roles));
    }
}