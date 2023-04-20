package com.alphatech.smile.service;

import com.alphatech.smile.dto.UserScoreDto;

import java.util.List;

public interface GameService {

    Long getUserScore(Long id);

    Long setUserScore(Long id, Long score);

    List<UserScoreDto> getAllUsers();
}
