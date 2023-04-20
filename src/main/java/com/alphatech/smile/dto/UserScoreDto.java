package com.alphatech.smile.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserScoreDto {
    private String username;
    private String name;
    private Long score;
}