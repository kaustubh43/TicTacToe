package main.java.com.tictactoe.controller;

import main.java.com.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    Game game;
    public BoardController boardController;

    public GameController(Game game) {
        this.game = game;
        this.boardController = new BoardController(game.getBoard());
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
        if (boardController.isBoardFull()) {
            game.setDraw();
            return;
        }

        // 1: Gets the current player with the next move.
        int currentPlayerIndex = game.getCurrPlayerIndex();
        Player currentPlayer = game.playerList.get(currentPlayerIndex);

        // 2: Gets the move from the current player into a "Cell" object
        System.out.printf("It is %s's turn\n", currentPlayer.getName());
        this.makeMoveForCurrentPlayer();

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

    public void undoLastMove(){
        //1. Remove from the moves list.
        Cell lastCellMove = game.moves.getLast();
        game.moves.removeLast();

        //2. Updating the board
        Cell cell = game.getBoard().getCells().get(lastCellMove.getRow()).get(lastCellMove.getCol());
        cell.setPlayer(null);
        cell.setCellState(CellState.FREE);

        // Update the current player index.
        this.game.currPlayerIndex = (game.getCurrPlayerIndex() - 1 + game.getPlayerList().size()) % game.getPlayerList().size();
    }

    /**
     * This method makes the next player decide a move and updates the board.
     * It updates the moves List as well.
     */
    public void makeMoveForCurrentPlayer() {
        Player currentPlayer = game.getPlayerList().get(game.getCurrPlayerIndex());
        // Get the move in Cell object format.
        Cell cell= currentPlayer.makeMove(game.getBoard(), currentPlayer);

        // 3: Update the board with the intended move (cell object), if it fails
        //    then recurse.
        try{
            this.boardController.updateBoard(cell, currentPlayer);
            this.game.updateMoves(cell);      // Update moves on that cell
        } catch (Exception e){
            System.out.printf("Not a valid move! Try again: %s\n", currentPlayer.getName());
            makeMoveForCurrentPlayer();
        }
    }
}
