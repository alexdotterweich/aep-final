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
        System.out.print(0 + "  " + board.get(0) + "|" + board.get(1) + "|" + board.get(2) + "\n");
        System.out.print("   -----" + "\n");
        System.out.print(1 + "  " + board.get(3) + "|" + board.get(4) + "|" + board.get(5) + "\n");
        System.out.print("   -----" + "\n");
        System.out.print(2 + "  " + board.get(6) + "|" + board.get(7) + "|" + board.get(8) + "\n");
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
            if (board.get(col + (row+4)) == " ") {
                board.set((col + (row+4)), "X");
                printBoard();
            } else {
                System.out.print("Square already filled, please try again" + "\n");
            }
        }
        else {
            System.out.print("Not a valid selection, please try again" + "\n");
        }
    }

    public boolean gameOver() {
        if ((board.get(0) == "X") & (board.get(1) == "X") & (board.get(2) == "X")) {
            return true;
        }

        else if ((board.get(3) == "X") & (board.get(4) == "X") & (board.get(5) == "X")) {
            return true;
        }

        else if ((board.get(6) == "X") & (board.get(7) == "X") & (board.get(8) == "X")) {
            return true;
        }

        else if ((board.get(0) == "X") & (board.get(3) == "X") & (board.get(6) == "X")) {
            return true;
        }

        else if ((board.get(1) == "X") & (board.get(4) == "X") & (board.get(7) == "X")) {
            return true;
        }

        else if ((board.get(2) == "X") & (board.get(5) == "X") & (board.get(8) == "X")) {
            return true;
        }

        else if ((board.get(0) == "X") & (board.get(4) == "X") & (board.get(8) == "X")) {
            return true;
        }

        else if ((board.get(2) == "X") & (board.get(4) == "X") & (board.get(6) == "X")) {
            return true;
        }

        return false;
    }

}
