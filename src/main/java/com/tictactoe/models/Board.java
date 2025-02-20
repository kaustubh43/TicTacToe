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
}
