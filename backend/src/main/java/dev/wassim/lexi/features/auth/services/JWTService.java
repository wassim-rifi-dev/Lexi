package dev.wassim.lexi.features.auth.services;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dev.wassim.lexi.domain.modal.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
    @Value("${app.jwt.secret-key}")
    public String Secret_Key;

    private SecretKey getSignInKey() {
        return Keys.hmacShaKeyFor(Secret_Key.getBytes());
    }

    public String createJwtToken(User user) {
        Key key = Keys.hmacShaKeyFor(
            Secret_Key.getBytes(StandardCharsets.UTF_8)
        );

        String token = Jwts.builder()
                            .subject(user.getEmail())
                            .claim("username", user.getUsername())
                            .issuedAt(new Date())
                            .expiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000))
                            .signWith(key)
                            .compact();

        return token;
    }

    public String extractUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                            .verifyWith(getSignInKey())
                            .build()
                            .parseSignedClaims(token)
                            .getPayload();

        return claims.getSubject();
    }
}
