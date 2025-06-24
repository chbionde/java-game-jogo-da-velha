package tictactoe.core;

import tictactoe.io.Input;
import tictactoe.io.Output;

public class Game {
    private final Board board = new Board();
    private final Players players = new Players();

    public void start() {
        while (true) {
            Output.writeNewLine();
            Output.write(board);
            play(players.next());
        }
    }

    private void play(Symbol symbol) {
        while (true) {
            try {
                String play = Input.read(String.format("'%s' Play =>", symbol));
                Coord coord = Coord.parse(play);
                board.update(symbol, coord);
                break;
            } catch (RuntimeException e) {
                Output.write("ERROR: "+e.getMessage());
            }
        }
    }

}
