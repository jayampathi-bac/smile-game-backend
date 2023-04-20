package com.alphatech.smile.controller;

import com.alphatech.smile.enumz.Role;
import com.alphatech.smile.config.security.UserPrincipal;
import com.alphatech.smile.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("change-role/{role}")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role){

        log.info("UserController : changeRole | Role {}", role );

        userService.changeRole(role, userPrincipal.getUsername());

        return ResponseEntity.ok(true);
    }




}
