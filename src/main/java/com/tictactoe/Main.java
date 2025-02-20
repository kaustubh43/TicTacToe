package main.java.com.tictactoe;

import main.java.com.tictactoe.controller.GameController;
import main.java.com.tictactoe.models.Board;
import main.java.com.tictactoe.models.Game;
import main.java.com.tictactoe.models.GameState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = GameController.InitialiseGame();
        GameController gc = new GameController(game);

        while(game.getGameState() == GameState.IN_PROGRESS){
            gc.boardController.displayBoard();
            // Prints the next player's move.
            // Ask the user for an input.
            gc.makeNextMove();
            gc.boardController.displayBoard();
            System.out.println("Do you want to undo? (y/n)");       // Todo: implement undo only for humans.
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("y")){
                gc.undoLastMove();
            }
        }
        if(game.getGameState() == GameState.WIN){
            System.out.printf("%s wins!\n", game.getWinner().getName());
            System.out.println("Winning Board");
            gc.boardController.displayBoard();
        }
        else{
            System.out.println("Draw!");
        }
    }
}
