package main.java.com.tictactoe;

import main.java.com.tictactoe.controller.GameController;
import main.java.com.tictactoe.models.Board;
import main.java.com.tictactoe.models.Game;
import main.java.com.tictactoe.models.GameState;

public class Main {
    public static void main(String[] args) {
        Game game = GameController.InitialiseGame();
        GameController gc = new GameController(game);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            game.getBoard().displayBoard();
            // Prints the next player's move.
            // Ask the user for an input.
            gc.makeNextMove();
        }
    }
}
