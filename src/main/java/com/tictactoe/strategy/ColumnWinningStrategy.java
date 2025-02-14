package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.Game;

public class ColumnWinningStrategy implements WinningStrategy {

    @Override
    public boolean isWinning(Game game) {
        // TODO: Iterate over Columns and decide if someone is winning.
        return false;
    }
}
