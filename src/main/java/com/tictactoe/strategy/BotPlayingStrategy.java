package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.Board;
import main.java.com.tictactoe.models.Cell;
import main.java.com.tictactoe.models.Game;
import main.java.com.tictactoe.models.Player;

public interface BotPlayingStrategy {
    Cell suggestMove(Player player, Board board);
}
