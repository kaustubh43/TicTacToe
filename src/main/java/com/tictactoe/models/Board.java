package main.java.com.tictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
    int N; // Dimension of the board. (N x N)
    public List<List<Cell>> cells = new ArrayList<>();

    public Board(int N) {
        if(N < 3)
            throw new IllegalArgumentException("N must be greater than 3");
        this.N = N;

        // Initialising a board.
        for(int i = 0; i < N; i++){
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j < N; j++){
                row.add(new Cell(i, j));
            }
            cells.add(row);
        }
    }

    public void displayBoard(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Cell cell = cells.get(i).get(j);
                if(cell.cellState == CellState.OCCUPIED) {
                    System.out.printf("| %c ", cell.player.symbol);  // Print the symbol of the player.
                }
                else{
                    System.out.print("|   ");  // Else print a blank space.
                }
            }
            System.out.println("| ");
        }
    }

    /**
     * @param cell
     * Makes Validations for a move from the player.
     */
    public void updateBoard(Cell cell, Player player){
        int row = cell.row;
        int col = cell.col;

        if(row < N && col < N && row >= 0 && col >= 0 && this.cells.get(row).get(col).cellState == CellState.FREE){
            this.cells.get(row).get(col).cellState = CellState.OCCUPIED;
            this.cells.get(row).get(col).player = player;
        }
        else{
            throw new IllegalArgumentException("The move is invalid.");
        }
    }

    public boolean isBoardFull(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(this.cells.get(i).get(j).cellState == CellState.FREE){
                    return false;
                }
            }
        }
        return true;
    }
}
