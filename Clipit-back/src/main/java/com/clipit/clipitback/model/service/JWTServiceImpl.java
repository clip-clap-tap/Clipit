package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("${secret-key}")
    private String secret_key;

    JWTServiceImpl() {

    }

    @Override
    public String createToken(UserInfo userInfo) {
        SecretKey secretKey = Keys.hmacShaKeyFor(secret_key.getBytes(StandardCharsets.UTF_8));
//        System.out.println(secretKey);
        Date exp = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        return Jwts.builder().header().add("typ", "JWT").and().claim("id", userInfo.getId()).expiration(exp).signWith(secretKey).compact();
    }

    @Override
    public Boolean validate(String token) {
        Map<String, ?> decodedToken = decode(token);
        System.out.println(decodedToken);
        return decodedToken == null;
    }

    public String getUserIdFromToken(String token) {
        return (String) decode(token).get("id");
    }

    @Override
    public Map<String, ?> decode(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(secret_key.getBytes(StandardCharsets.UTF_8));
        Jws<Claims> jwsClaims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
//        System.out.println(jwsClaims.getPayload().get("id"));
        Claims payload = jwsClaims.getPayload();
        Map<String, ?> decodedToken = Map.of("id", payload.get("id"));
        return decodedToken;
    }


}
