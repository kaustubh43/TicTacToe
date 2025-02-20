package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Cell suggestMove(Player player, Board board) {
        int N = board.getN();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Cell cell = board.getCells().get(i).get(j);
                if(cell.getCellState() == CellState.FREE){
                    return cell;
                }
            }
        }
        throw new IllegalArgumentException("No free cells found, internal error");
    }
}
