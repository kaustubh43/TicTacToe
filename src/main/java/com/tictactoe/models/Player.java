package main.java.com.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public abstract class Player {
    String name;
    Character symbol;
    int id;

    /**
     * @return Cell object
     */
    public abstract Cell makeMove();
    // human player or bot player will implement this method.
}
