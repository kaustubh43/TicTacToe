package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        return switch (botDifficultyLevel){
            case EASY -> new EasyBotPlayingStrategy();
            // Not required to have a default case, since it is default.
            case HARD -> new HardBotPlayingStrategy();
            default -> new MediumBotPlayingStrategy();
        };
    }
}
