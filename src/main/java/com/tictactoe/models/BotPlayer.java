package main.java.com.tictactoe.models;

import java.util.Scanner;

public class BotPlayer extends Player {
    public BotDifficultyLevel botDifficultyLevel;

    public BotPlayer(String name, Character symbol, int id) {
        super(name, symbol, id);
    }

    @Override
    public Cell makeMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your next move");
        // Todo: Implement bot player functionality. try to use chat gpt api.
        int row = sc.nextInt();
        int col = sc.nextInt();

        return new Cell(row, col);
    }
}
