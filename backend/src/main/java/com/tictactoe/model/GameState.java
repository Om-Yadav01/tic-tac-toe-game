package com.tictactoe.model;

public class GameState {
    private String[] board;
    private String currentPlayer;
    private String winner;
    private boolean gameOver;

    public GameState() {
        this.board = new String[9];
        for (int i = 0; i < 9; i++) {
            this.board[i] = null;
        }
        this.currentPlayer = "X";
        this.winner = null;
        this.gameOver = false;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
} 