package tictactoe.core;

public class Game {
    private final Board board = new Board();
    private final Players players = new Players();

    public void start() {
        System.out.println(board);
    }

}
