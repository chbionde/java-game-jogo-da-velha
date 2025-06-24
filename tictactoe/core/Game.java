package tictactoe.core;

import tictactoe.io.Output;

public class Game {
    private final Board board = new Board();
    private final Players players = new Players();

    public void start() {
        while (true) {
            Output.write(board);
            Output.writeNewLine();

        }
    }

}
