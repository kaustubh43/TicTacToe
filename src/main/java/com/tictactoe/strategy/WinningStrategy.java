package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.Game;

public interface WinningStrategy {
    boolean isWinning(Game game);
}
