package game;

import java.util.List;
import java.util.Arrays;

// Understands how to setup and retrieve board information, knows when the game is over
public class Board {
    protected List<String> board;

    public Board() {
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

    public int getIndex(int row, int col) {
        return col / 3 + row - row % 3;
    }


    public void setBoard(int row, int col, Player p) {
        if (((row + 3) % 3) == 0) { //in the first row of board
            if (board.get(col) == " ") { //board is empty at place
                board.set(col, p.playerType);
                printBoard();
            } else {
                System.out.print("Square already filled, please try again" + "\n");
            }
        }

        else if (((row + 2) % 3) == 0) {
            if (board.get(col + (row+2)) == " ") {
                board.set((col + (row+2)), p.playerType);
            } else {
                System.out.print("Square already filled, please try again" + "\n");
            }
        }

        else if (((row + 1) % 3) == 0) {
            if (board.get(col + (row+4)) == " ") {
                board.set((col + (row+4)), p.playerType);
                printBoard();
            } else {
                System.out.print("Square already filled, please try again" + "\n");
            }
        }
        else {
            System.out.print("Not a valid selection, please try again" + "\n");
        }
    }

    public boolean gameOver(Player p) {
        if ((board.get(0) == p.playerType) & (board.get(1) == p.playerType) & (board.get(2) == p.playerType)) {
            return true;
        }

        else if ((board.get(3) == p.playerType) & (board.get(4) == p.playerType) & (board.get(5) == p.playerType)) {
            return true;
        }

        else if ((board.get(6) == p.playerType) & (board.get(7) == p.playerType) & (board.get(8) == p.playerType)) {
            return true;
        }

        else if ((board.get(0) == p.playerType) & (board.get(3) == p.playerType) & (board.get(6) == p.playerType)) {
            return true;
        }

        else if ((board.get(1) == p.playerType) & (board.get(4) == p.playerType) & (board.get(7) == p.playerType)) {
            return true;
        }

        else if ((board.get(2) == p.playerType) & (board.get(5) == "X") & (board.get(8) == "X")) {
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

    public boolean boardFull() {
        for (int i = 0 ; i < board.size(); i ++) {
            if (board.get(i) == " ") {
                return false;
            }
        } return true;
    }

}
