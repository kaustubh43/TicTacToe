package main.java.com.tictactoe.models;

import lombok.*;
import main.java.com.tictactoe.strategy.ColumnWinningStrategy;
import main.java.com.tictactoe.strategy.RowWinningStrategy;
import main.java.com.tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Game {
    public Board board;
    public List<Player> playerList;
    public int currPlayerIndex;
    public List<Cell> moves;
    @Setter
    GameState gameState;
    List<WinningStrategy> winningStrategies;
    Player winner;

    public Game(int N, List<Player> playerList) {
        this.board = new Board(N);
        this.playerList = playerList;
        currPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.gameState = GameState.INIT;
        winningStrategies = new ArrayList<>(List.of(new RowWinningStrategy(),
                new ColumnWinningStrategy()));
    }

    public void setWinner(Player winner) {
        this.winner = winner;
        this.gameState = GameState.WIN;
    }

    public void setDraw(){
        this.gameState = GameState.DRAW;
    }

    public void updateMoves(Cell cell) {
        moves.add(cell);
    }
    //    public void changeTurn(){
//        this.currPlayerIndex = (this.currPlayerIndex + 1) % playerList.size();
//    }

}
