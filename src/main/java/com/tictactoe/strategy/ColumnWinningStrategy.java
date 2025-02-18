package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.CellState;
import main.java.com.tictactoe.models.Game;
import main.java.com.tictactoe.models.Player;
import main.java.com.tictactoe.models.Cell;

public class ColumnWinningStrategy implements WinningStrategy {

    @Override
    public boolean isWinning(Game game) {
        Player currentPlayer = game.getPlayerList().get(game.getCurrPlayerIndex());

        Cell currentMove = game.moves.getLast();
        int column = currentMove.getCol();

        for(int i = 0; i < game.board.getN(); i++){
            Cell cell = game.board.getCells().get(i).get(column);
            if(cell.getCellState() == CellState.FREE || currentPlayer != cell.getPlayer()){
                return false;
            }
        }
        return true;
    }
}
