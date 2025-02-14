package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.Game;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean isWinning(Game game) {
        //TODO: Iterate over Rows and decide if someone is winning.
        return false;
    }
}
