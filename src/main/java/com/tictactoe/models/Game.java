package main.java.com.tictactoe.models;

import lombok.*;
import main.java.com.tictactoe.strategy.ColumnWinningStrategy;
import main.java.com.tictactoe.strategy.DiagonalWinningStrategy;
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
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()));
    }

    public void setDraw(){
        this.gameState = GameState.DRAW;
    }

    public void updateMoves(Cell cell) {
        moves.add(cell);
    }

    /**
     * This method makes the next player decide a move and updates the board.
     * It updates the moves List as well.
     */
    public void makeMoveForCurrentPlayer() {
        Player currentPlayer = playerList.get(currPlayerIndex);
        // Get the move in Cell object format.
        Cell cell= currentPlayer.makeMove(board, currentPlayer);

        // 3: Update the board with the intended move (cell object), if it fails
        //    then recurse.
        try{
            this.board.updateBoard(cell, currentPlayer);
            this.updateMoves(cell);      // Update moves on that cell
        } catch (Exception e){
            System.out.printf("Not a valid move! Try again: %s\n", currentPlayer.getName());
            makeMoveForCurrentPlayer();
        }
    }

    public void postMoveWinnerCheck() {
        // Check Winning Strategies
        boolean isWin = this.getWinningStrategies().stream()
                .anyMatch(winningStrategy -> winningStrategy.isWinning(this));

        Player currentPlayer = playerList.get(currPlayerIndex);
        if(isWin){
            // Store the winning player.
            // Change the game state.
            winner = currentPlayer;
            gameState = GameState.WIN;
        }
        else{
            this.currPlayerIndex = currPlayerIndex + 1;
            this.currPlayerIndex %= this.getPlayerList().size();
        }
    }

}
