package main.java.com.tictactoe.controller;

import lombok.AllArgsConstructor;
import main.java.com.tictactoe.models.Board;
import main.java.com.tictactoe.models.Cell;
import main.java.com.tictactoe.models.CellState;
import main.java.com.tictactoe.models.Player;


public class BoardController {
    Board board;
    int N;

    public void displayBoard(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Cell cell = board.getCells().get(i).get(j);
                if(cell.getCellState() == CellState.OCCUPIED) {
                    System.out.printf("| %c ", cell.getPlayer().getSymbol());  // Print the symbol of the player.
                }
                else{
                    System.out.print("|   ");  // Else print a blank space.
                }
            }
            System.out.println("| ");
        }
    }

    public BoardController(Board board) {
        this.board = board;
        N = board.getN();
    }

    /**
     * @param cell
     * Makes Validations for a move from the player.
     */
    public void updateBoard(Cell cell, Player player){
        int row = cell.getRow();
        int col = cell.getCol();

        if(row < N && col < N && row >= 0 && col >= 0 && this.board.getCells().get(row).get(col).getCellState() == CellState.FREE){
            this.board.getCells().get(row).get(col).updateCell(player);
        }
        else{
            throw new IllegalArgumentException("The move is invalid.");
        }
    }

    public boolean isBoardFull(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(this.board.getCells().get(i).get(j).getCellState() == CellState.FREE){
                    return false;
                }
            }
        }
        return true;
    }
}
