package tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Board {

    public static final int SIZE = 3;
    private final Symbol[][] matrix = new Symbol[SIZE][SIZE];

    public Board() {
        for (Symbol[] symbols : matrix) {
            Arrays.fill(symbols, Symbol.NONE);
        }
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (j != 0) {
                    out.print(" | ");
                }
                out.print(matrix[i][j]);
            }
            out.println();
            if (i != 2){
                out.println("---------");
            }
        }

        return sw.toString();
    }
}
