/* package com.walletapp.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private String secretKey = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924"; // Clave secreta para
                                                                                                   // firmar el token
    private long validityInMilliseconds = 3600000; // 1 hora

    // Método para generar un token JWT basado en el nombre de usuario
    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Método para extraer el nombre de usuario del token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Método para extraer los detalles del token (Claims)
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // Método para verificar si el token es válido
    public boolean validateToken(String token) {
        try {
            // Verificar si el token ha expirado
            extractClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // Si el token es inválido o ha expirado, devolver false
            return false;
        }
    }

    // Método para verificar si el token ha expirado
    public boolean isTokenExpired(String token) {
        Date expiration = extractClaims(token).getExpiration();
        return expiration.before(new Date());
    }
}
 */