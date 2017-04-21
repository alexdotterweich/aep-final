package game;

import java.util.List;
import java.util.Arrays;

// Understands how to setup and retrieve board information, knows when the game is over
public class Board {
    private List<String> board;

    protected Board() {
        this.board = Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
    }

    public List getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.print("---------------------------" + '\n');
        System.out.print("   0 1 2   Cols" + "\n");
        System.out.print("\n");
        int rows = board.size()/3;
        for (int i = 0; i < rows; i++) {
            System.out.print(i + "  " + board.get(i) + "|" + board.get(i+1) + "|" + board.get(i+2) + "\n");
        }
        System.out.print("\n" + "Rows" + "\n");
        System.out.print("---------------------------");
    }
}
