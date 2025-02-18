package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.Game;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinning(Game game) {
        return false;
    }
}
