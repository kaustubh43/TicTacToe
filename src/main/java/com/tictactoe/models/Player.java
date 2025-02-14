package main.java.com.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Player {
    String name;
    Character symbol;
    int id;

    public Player(String name, Character symbol, int id) {
        this.name = name;
        this.symbol = symbol;
        this.id = id;
    }

    public abstract void makeMove();
    // human player or bot player will implement this method.
}
