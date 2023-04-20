package com.alphatech.smile.service;

import com.alphatech.smile.dto.UserDto;

public interface AuthenticationService {
    UserDto signInAndReturnJWT(UserDto signInRequest);
}
