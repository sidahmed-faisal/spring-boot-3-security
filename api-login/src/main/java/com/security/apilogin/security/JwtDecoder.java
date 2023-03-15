package com.security.apilogin.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtDecoder {
    @Value("${jwt.secret}")
    private String secret ;
    public DecodedJWT decode(String token){
        return JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token);
    }
}
