package com.security.apilogin.controller;

import com.security.apilogin.model.LoginRequest;
import com.security.apilogin.model.LoginResponse;
import com.security.apilogin.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    //using final is same as creating a constructor like this:
//    public AuthController(JwtIssuer jwtIssuer) {
//        this.jwtIssuer = jwtIssuer;
//    }
    private final JwtIssuer jwtIssuer;



    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        var token = jwtIssuer.issue(1L ,request.getEmail() , List.of("USER"));
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
