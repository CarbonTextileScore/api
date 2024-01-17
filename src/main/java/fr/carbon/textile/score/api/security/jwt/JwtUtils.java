package fr.carbon.textile.score.api.security.jwt;

import fr.carbon.textile.score.api.security.user.details.UserDetailsImplementation;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${carbon.textile.score.access.point.jwt.key}")
    private String _jwtSecret;
    @Value("${carbon.textile.score.access.point.jwt.expiration}")
    private int _jwtExpirationMs;

    public String generateJwtToken(@NotNull Authentication authentication) {
        UserDetailsImplementation userPrincipal = (UserDetailsImplementation) authentication.getPrincipal();
        return Jwts
                .builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + _jwtExpirationMs))
                .signWith(getHMACKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getHMACKey() {
        return Keys.hmacShaKeyFor(_jwtSecret.getBytes());
    }

    public String parseJwt(@NonNull HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (!StringUtils.hasText(headerAuth) || !headerAuth.startsWith("Bearer ")) {
            return null;
        }

        return headerAuth.substring(7);
    }

    public String getUsernameFromJwtToken(@NotBlank String token) {
        return Jwts.parserBuilder().setSigningKey(getHMACKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean isJwtTokenNotValidated(@NotBlank String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(getHMACKey()).build().parseClaimsJws(authToken);
            return false;
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            LOGGER.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims string is empty: {}", e.getMessage());
        }

        return true;
    }
}
