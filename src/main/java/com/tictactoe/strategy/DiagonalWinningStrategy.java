package main.java.com.tictactoe.strategy;

import main.java.com.tictactoe.models.CellState;
import main.java.com.tictactoe.models.Game;
import main.java.com.tictactoe.models.Player;
import main.java.com.tictactoe.models.Cell;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean isWinning(Game game) {
        return topLeftToBottomRight(game) || topRightToBottomLeft(game);
    }

    private boolean topRightToBottomLeft(Game game) {
        Player currentPlayer = game.getPlayerList().get(game.currPlayerIndex);
        int N = game.getBoard().getN();
        // Top left - Botton Right Diagonal
        for(int i = 0; i < game.board.getN(); i++){
            Cell cell = game.board.getCells().get(i).get(N - i - 1);
            if(cell.getCellState() == CellState.FREE || currentPlayer != cell.getPlayer()){
                return false;
            }
        }
        return true;
    }

    public boolean topLeftToBottomRight(Game game) {
        Player currentPlayer = game.getPlayerList().get(game.currPlayerIndex);

        // Top left - Botton Right Diagonal
        for(int i = 0; i < game.board.getN(); i++){
            Cell cell = game.board.getCells().get(i).get(i);
            if(cell.getCellState() == CellState.FREE || currentPlayer != cell.getPlayer()){
                return false;
            }
        }
        return true;
    }
}
