package com.alphatech.smile.dto;


import com.alphatech.smile.enumz.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;

    private String username;

    private String password;

    private String name;
    private Long score;

    private LocalDateTime createTime;

    private Role role;

    private String token;
}