package com.alphatech.smile.service;

import com.alphatech.smile.dto.UserDto;
import com.alphatech.smile.enumz.Role;

import java.util.Optional;

public interface UserService {
    UserDto saveUser(UserDto user);

    Optional<UserDto> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
