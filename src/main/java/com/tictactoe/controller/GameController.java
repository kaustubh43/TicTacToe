package main.java.com.tictactoe.controller;

import main.java.com.tictactoe.models.Game;
import main.java.com.tictactoe.models.GameState;
import main.java.com.tictactoe.models.HumanPlayer;
import main.java.com.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    Game game;

    public GameController(Game game) {
        this.game = game;
        game.setGameState(GameState.IN_PROGRESS);
    }

    public static Game InitialiseGame() {
        //TODO: Make a builder dp here.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Board size: ");
        int N = sc.nextInt();

        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i < N - 1; i++) {
            System.out.println("Enter the player name");
            String playerName = sc.next();
            System.out.println("Enter the player symbol");
            String playerSymbol = sc.next();

            players.add(new HumanPlayer(playerName, playerSymbol.charAt(0), i + 1));
        }
        return new Game(N, players);
    }

    public void makeNextMove() {
        int currentPlayerIndex = game.getCurrPlayerIndex();
        Player currentPlayer = game.playerList.get(currentPlayerIndex);

        System.out.printf("It is %s's turn\n", currentPlayer.getName());
        currentPlayer.makeMove();

        // Todo: increment the current player index.
        game.changeTurn();
        // Todo: check if somebody won
    }
}
