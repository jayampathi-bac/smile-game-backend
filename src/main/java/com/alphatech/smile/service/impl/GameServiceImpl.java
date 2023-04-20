package com.alphatech.smile.service.impl;

import com.alphatech.smile.dto.UserScoreDto;
import com.alphatech.smile.model.User;
import com.alphatech.smile.repository.UserRepository;
import com.alphatech.smile.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GameServiceImpl implements GameService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public GameServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Long getUserScore(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return user.get().getScore();
        return 0L;
    }

    @Override
    public Long setUserScore(Long id, Long score) {
        User user = userRepository.getById(id);
        long userNewScore = score + user.getScore();
        user.setScore(userNewScore);
        userRepository.save(user);
        return userNewScore;
    }

    @Override
    public List<UserScoreDto> getAllUsers() {
        List<User> all = userRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
        return all.stream().map(this::formatUserEntity).toList();
    }

    private UserScoreDto formatUserEntity(User user) {
        return modelMapper.map(user, UserScoreDto.class);
    }
}
