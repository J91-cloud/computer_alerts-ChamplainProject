package com.calerts.computer_alertsbe.AuthDomain.system;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.webapp.computer_alerts.AuthDomain.data.UserDetails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtVerifier {
    private final String issuer;
    private final String secret;

    public JwtVerifier(@Value("${auth0.issuer}") String issuer,
                       @Value("${auth0.secret}") String secret) {
        this.issuer = issuer;
        this.secret = secret;
    }

    public String generateToken(UserDetails userDetails) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer(issuer)
                .withSubject(userDetails.getUsername())
                .withArrayClaim("roles", userDetails.getRoles().toArray(new String[0]))
                .withExpiresAt(new Date(System.currentTimeMillis() + 86400000)) // Token expires in 24 hours
                .sign(algorithm);
    }
}
