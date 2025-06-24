package tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.classfile.instruction.ReturnInstruction;
import java.util.Arrays;
import static java.util.Objects.requireNonNull;

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

    public Symbol update(Symbol symbol, Coord coord) {
        requireNonNull(symbol);
        requireNonNull(coord);

        if (symbol == Symbol.NONE) {
            throw new IllegalArgumentException("None cannot be added to board");
        }

        if (matrix[coord.i()][coord.j()] != Symbol.NONE) {
            throw new IllegalArgumentException("Play is not possible");
        }

        matrix[coord.i()][coord.j()] = symbol;
        return findSequence();
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] == Symbol.NONE){
                    return false;
                }
            }
        }
        return true;
    }

    private Symbol findSequence() {
        for (int i = 0; i < SIZE; i++){
            Symbol symbol = findSequenceInRowsAndColumns(i, true);
            if (symbol != null) {
                return symbol;
            }
            symbol = findSequenceInRowsAndColumns(i, false);
            if (symbol != null) {
                return symbol;
            }
        }
        return findSequenceInDiagonals();
    }

    private Symbol findSequenceInRowsAndColumns(int i, boolean line) {
        if (line) {
            return matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != Symbol.NONE? matrix[i][0] : null;
        }
        return matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[0][i] != Symbol.NONE? matrix[0][i] : null;
    }

    private Symbol findSequenceInDiagonals() {
        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != Symbol.NONE) {
            return matrix[0][0];
        }

        if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] != Symbol.NONE) {
            return matrix[0][2];
        }

        return null;
    }

}
