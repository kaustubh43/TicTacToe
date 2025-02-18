package main.java.com.tictactoe.models;

import lombok.Getter;

@Getter
public class Cell {
    int row, col;

    Player player;
    CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.FREE;
    }

    public void updateCell(Player player){
        this.cellState = CellState.OCCUPIED;
        this.player = player;
    }
}
