package main.java.com.tictactoe.models;

import lombok.Setter;

import java.util.Scanner;

@Setter
public class HumanPlayer extends Player {

    String email;

    public HumanPlayer(String name, Character symbol, int id) {
        super(name, symbol, id);
    }

    @Override
    public void makeMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your next move");
        int row = sc.nextInt();
        int col = sc.nextInt();

    }
}
