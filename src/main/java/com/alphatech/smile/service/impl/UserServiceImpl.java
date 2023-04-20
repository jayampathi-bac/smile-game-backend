package com.alphatech.smile.service.impl;

import com.alphatech.smile.dto.UserDto;
import com.alphatech.smile.enumz.Role;
import com.alphatech.smile.model.User;
import com.alphatech.smile.repository.UserRepository;
import com.alphatech.smile.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto saveUser(UserDto user) {

        log.info("UserServiceImpl : saveUser | Request {}", user);

        User save = userRepository.save(User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .name(user.getName())
                .createTime(LocalDateTime.now())
                .role(Role.USER)
                .score(0L)
                .build());

        return UserDto.builder()
                .username(save.getUsername())
                .password(save.getPassword())
                .name(save.getName())
                .createTime(save.getCreateTime())
                .role(save.getRole())
                .score(save.getScore())
                .build();
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {

        Optional<User> getUser = userRepository.findByUsername(username);

        return getUser.map(user -> UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .createTime(user.getCreateTime())
                .role(user.getRole())
                .score(user.getScore())
                .build());

    }
}
