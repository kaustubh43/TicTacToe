package main.java.com.tictactoe.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Game {
    public Board board;
    public List<Player> playerList;
    int currPlayerIndex;
    List<Cell> moves;
    @Setter
    GameState gameState;

    public Game(int N, List<Player> playerList) {
        this.board = new Board(N);
        this.playerList = playerList;
        currPlayerIndex = 0;
        List<Cell> moves = new ArrayList<>();
        this.gameState = GameState.INIT;
    }

    public void changeTurn(){
        this.currPlayerIndex = (this.currPlayerIndex + 1) % playerList.size();
    }

}
