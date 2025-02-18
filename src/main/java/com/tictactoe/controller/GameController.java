package main.java.com.tictactoe.controller;

import main.java.com.tictactoe.models.Game;
import main.java.com.tictactoe.models.GameState;
import main.java.com.tictactoe.models.HumanPlayer;
import main.java.com.tictactoe.models.Player;
import main.java.com.tictactoe.models.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    Game game;

    public GameController(Game game) {
        this.game = game;
        // After initialisation set game to "IN_PROGRESS"
        game.setGameState(GameState.IN_PROGRESS);
    }

    public static Game InitialiseGame() {
        //TODO: Make a builder dp here.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Board size: ");
        int N = sc.nextInt();

        List<Player> players = new ArrayList<>();
        for(int i = 0; i < N - 1; i++) {
            System.out.println("Enter the player name");
            String playerName = sc.next();
            System.out.println("Enter the player symbol");
            String playerSymbol = sc.next();

            players.add(new HumanPlayer(playerName, playerSymbol.charAt(0), i + 1));
        }
        return new Game(N, players);
    }

    /**
     * Helps the user make the next move.
     * 1. Finds the player with the next move.
     * 2. Calls the makeMove method for the corresponding player.
     * 3. Update the board with the move and validations for that move.
     * 4. Check all winning strategies.
     * 5. Displays the moves.
     */
    public void makeNextMove() {
        if (game.board.isBoardFull()) {
            game.setDraw();
            return;
        }

        // 1: Gets the current player with the next move.
        int currentPlayerIndex = game.getCurrPlayerIndex();
        Player currentPlayer = game.playerList.get(currentPlayerIndex);

        // 2: Gets the move from the current player into a "Cell" object
        System.out.printf("It is %s's turn\n", currentPlayer.getName());
        Cell cell= currentPlayer.makeMove();

        // 3: Update the board with the intended move (cell object), if it fails
        //    then recurse.
        try{
            game.board.updateBoard(cell, currentPlayer);
        } catch (Exception e){
            System.out.printf("Not a valid move! Try again: %s", currentPlayer.getName());
            makeNextMove();
            return;
        }

        // Update move on that cell
        game.updateMoves(cell);

        // Check Winning Strategies
        boolean isWin = game.getWinningStrategies().stream()
                .anyMatch(winningStrategy -> winningStrategy.isWinning(game));

        if(isWin){
            // Store the winning player.
            // Change the game state.
            game.setWinner(currentPlayer);
        }
        else{
            game.currPlayerIndex = currentPlayerIndex + 1;
            game.currPlayerIndex %= game.getPlayerList().size();
        }
    }
}
