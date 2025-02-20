package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Cell suggestMove(Player player, Board board) {
        int N = board.getN();

        List<Cell> freeCells = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Cell cell = board.getCells().get(i).get(j);
                if(cell.getCellState() == CellState.FREE) {
                    freeCells.add(cell);
                }
            }
        }
        // This state should never be reached.
        if(freeCells.isEmpty()) {
            throw new IllegalArgumentException("No free cells found, internal error");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(freeCells.size());

        return freeCells.get(randomIndex);
    }
}
