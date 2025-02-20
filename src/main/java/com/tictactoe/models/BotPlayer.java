package main.java.com.tictactoe.models;

import main.java.com.tictactoe.strategy.BotPlayingStrategy;
import main.java.com.tictactoe.strategy.BotPlayingStrategyFactory;

import java.util.Scanner;

public class BotPlayer extends Player {
    public BotDifficultyLevel botDifficultyLevel;
    public BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String name, Character symbol, int id, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, id);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Cell makeMove(Board board, Player player) {
        return botPlayingStrategy.suggestMove(player, board);
    }
}
