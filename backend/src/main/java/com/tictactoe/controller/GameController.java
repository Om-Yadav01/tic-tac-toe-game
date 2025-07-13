package com.tictactoe.controller;

import com.tictactoe.model.GameState;
import com.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    @GetMapping("/state")
    public GameState getGameState() {
        return gameService.getGameState();
    }
    
    @PostMapping("/move/{position}")
    public GameState makeMove(@PathVariable int position) {
        return gameService.makeMove(position);
    }
    
    @PostMapping("/reset")
    public GameState resetGame() {
        return gameService.resetGame();
    }
} 