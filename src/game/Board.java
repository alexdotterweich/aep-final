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
        int rows = board.size() / 3;
        for (int i = 0; i < rows; i++) {
            System.out.print(i + "  " + board.get(i) + "|" + board.get(i + 1) + "|" + board.get(i + 2) + "\n");
        }
        System.out.print("\n" + "Rows" + "\n");
        System.out.print("---------------------------" + "\n");
    }

    public void setBoard(int row, int col) {
        if (((row + 3) % 3) == 0) { //in the first row of board
            if (board.get(col) == " ") { //board is empty at place
                board.set(col, "X");
                printBoard();
            } else {
                System.out.print("Square already filled, please try again" + "\n");
            }
        }

        else if (((row + 2) % 3) == 0) {
            if (board.get(col + (row+2)) == " ") {
                board.set((col + (row+2)), "X");
            } else {
                System.out.print("Square already filled, please try again" + "\n");
            }
        }

        else if (((row + 1) % 3) == 0) {
            if (board.get(col + (row+1)) == " ") {
                board.set(col, "X");
                printBoard();
            } else {
                System.out.print("Square already filled, please try again" + "\n");
            }
        }
        else {
            System.out.print("Not a valid selection, please try again" + "\n");
        }
    }
}
