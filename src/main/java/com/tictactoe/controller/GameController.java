package main.java.com.tictactoe.controller;

import main.java.com.tictactoe.models.*;

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
        for(int id = 0; id < N - 1; id++) {
            players.add(getPlayerFromUser(id));
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
        // Check if board is full, before proceeding with the steps.
        if (game.board.isBoardFull()) {
            game.setDraw();
            return;
        }

        // 1: Gets the current player with the next move.
        int currentPlayerIndex = game.getCurrPlayerIndex();
        Player currentPlayer = game.playerList.get(currentPlayerIndex);

        // 2: Gets the move from the current player into a "Cell" object
        System.out.printf("It is %s's turn\n", currentPlayer.getName());
        game.makeMoveForCurrentPlayer();

        // 4: Check all the winning strategies.
        game.postMoveWinnerCheck();
    }

    public static Player getPlayerFromUser(int playerId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the player name");
        String playerName = sc.next();
        System.out.println("Enter the player symbol");
        String playerSymbol = sc.next();
        System.out.println("Is it a bot player ? (Y/N)");
        String botPlayer = sc.next();
        if(botPlayer.equalsIgnoreCase("Y")) {
            System.out.println("Enter the difficulty level (1/2/3)");
            int val = sc.nextInt();
            BotDifficultyLevel botDifficultyLevel = switch (val){
                case 1 -> BotDifficultyLevel.EASY;
                // Medium is default, hence no explicit mention.
                case 3 -> BotDifficultyLevel.HARD;
                default -> BotDifficultyLevel.MEDIUM;
            };
            System.out.printf("%s difficulty level selected.\n", botDifficultyLevel);
            return new BotPlayer(playerName, playerSymbol.charAt(0), playerId + 1, botDifficultyLevel);
        }
        return new HumanPlayer(playerName, playerSymbol.charAt(0), playerId + 1);
    }
}
