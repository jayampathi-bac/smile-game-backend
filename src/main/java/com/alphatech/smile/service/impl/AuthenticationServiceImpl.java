package com.alphatech.smile.service.impl;

import com.alphatech.smile.config.security.UserPrincipal;
import com.alphatech.smile.config.security.jwt.JwtProvider;
import com.alphatech.smile.dto.UserDto;
import com.alphatech.smile.model.User;
import com.alphatech.smile.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public UserDto signInAndReturnJWT(UserDto signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return UserDto.builder()
                .id(signInUser.getId())
                .username(signInUser.getUsername())
                .password(signInUser.getPassword())
                .name(signInUser.getName())
                .createTime(signInUser.getCreateTime())
                .role(signInUser.getRole())
                .token(signInUser.getToken())
                .build();
    }
}
