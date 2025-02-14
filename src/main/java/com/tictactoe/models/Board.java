package main.java.com.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int N; // Dimension of the board. (N x N)
    List<List<Cell>> cells = new ArrayList<>();

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
                    System.out.printf("|%s ", cell.player.symbol);
                }
                else{
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
    }
}
