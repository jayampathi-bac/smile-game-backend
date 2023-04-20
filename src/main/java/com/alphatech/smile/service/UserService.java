package com.alphatech.smile.service;

import com.alphatech.smile.dto.UserDto;

import java.util.Optional;

public interface UserService {
    UserDto saveUser(UserDto user);

    Optional<UserDto> findByUsername(String username);
}
