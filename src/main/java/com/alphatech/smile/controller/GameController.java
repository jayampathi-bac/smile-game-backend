package com.alphatech.smile.controller;

import com.alphatech.smile.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/game/score")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<Object> getUserScore(@RequestParam Long id) {
        log.info("GameController : getUserScore : id :{}", id);
        return new ResponseEntity<>(gameService.getUserScore(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> setUserScore(@RequestParam Long id, @RequestParam Long score) {
        log.info("GameController : getUserScore : id :{}", id);
        return new ResponseEntity<>(gameService.setUserScore(id, score), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers() {
        log.info("GameController : getAllUsers ");
        return new ResponseEntity<>(gameService.getAllUsers(), HttpStatus.OK);
    }
}
