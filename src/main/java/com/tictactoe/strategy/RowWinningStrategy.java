package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.Cell;
import main.java.com.tictactoe.models.CellState;
import main.java.com.tictactoe.models.Game;
import main.java.com.tictactoe.models.Player;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean isWinning(Game game) {
        // O(N)
        Player currentPlayer = game.playerList.get(game.getCurrPlayerIndex());
        Cell currentMove = game.moves.getLast();

        int row = currentMove.getRow();
        for(int i = 0; i < game.board.getN(); i++){
            Cell cell = game.board.getCells().get(row).get(i);
            if(cell.getCellState() == CellState.FREE || currentPlayer != cell.getPlayer()){
                return false;
            }
        }
        return true;
    }
}
