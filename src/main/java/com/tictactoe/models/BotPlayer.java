package main.java.com.tictactoe.models;

import java.util.Scanner;

public class BotPlayer extends Player {
    public BotDifficultyLevel botDifficultyLevel;

    public BotPlayer(String name, Character symbol, int id, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, id);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public void makeMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your next move");
        int row = sc.nextInt();
        int col = sc.nextInt();

    }
}
