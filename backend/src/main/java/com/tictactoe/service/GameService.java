package com.tictactoe.service;

import com.tictactoe.model.GameState;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    
    private GameState gameState;
    
    public GameService() {
        this.gameState = new GameState();
    }
    
    public GameState getGameState() {
        return gameState;
    }
    
    public GameState makeMove(int position) {
        if (gameState.isGameOver() || gameState.getBoard()[position] != null) {
            return gameState;
        }
        
        gameState.getBoard()[position] = gameState.getCurrentPlayer();
        
        // Check for winner
        String winner = checkWinner(gameState.getBoard());
        if (winner != null) {
            gameState.setWinner(winner);
            gameState.setGameOver(true);
        } else if (isBoardFull(gameState.getBoard())) {
            gameState.setGameOver(true);
        } else {
            // Switch player
            gameState.setCurrentPlayer(gameState.getCurrentPlayer().equals("X") ? "O" : "X");
        }
        
        return gameState;
    }
    
    public GameState resetGame() {
        this.gameState = new GameState();
        return gameState;
    }
    
    private String checkWinner(String[] board) {
        // Winning combinations
        int[][] lines = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}              // Diagonals
        };
        
        for (int[] line : lines) {
            if (board[line[0]] != null &&
                board[line[0]].equals(board[line[1]]) &&
                board[line[0]].equals(board[line[2]])) {
                return board[line[0]];
            }
        }
        return null;
    }
    
    private boolean isBoardFull(String[] board) {
        for (String cell : board) {
            if (cell == null) {
                return false;
            }
        }
        return true;
    }
} 