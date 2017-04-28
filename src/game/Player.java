package game;
import java.util.Scanner;
import java.util.ArrayList;

// Understands how to play the game in the command line
public class Player {

    protected String playerType = "X";
    protected int row;
    protected int col;

    public Player() {
        this.row = row;
        this.col = col;
    }

    public int valueAsker(String colOrRow) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Choose the " + colOrRow + " you would like to select from 0 - 2" + "\n");
        int userValue = reader.nextInt();
        if ((userValue < 0) || (userValue > 2)) {
            System.out.print("Value out of range, please try again" + "\n");
            return valueAsker(colOrRow);
        }
        if (colOrRow == "row") {
            row = userValue;
        } else { col = userValue; }

        return userValue;
    }

    public String playerOpposite() {
        if (playerType == "X") {
            return "O";
        } return "X";
    }


    // checks to see if next move will result in the player winning
    public int willPlayerWin(Board b, String playerType) {
        for(int i = 0; i < 9 ; i++) {
            if (b.board.get(i) == " ") {
                b.board.set(i, playerType);
                if (b.gameOver(this)) {
                    b.board.set(i, " ");
                    return i;
                } b.board.set(i, " ");
            }
        } return -1;
    }

    public int ai(Board b){
        if (willPlayerWin(b, "O") != -1) {
            return willPlayerWin(b, "O");
        } if (willPlayerWin(b, "X") != -1) {
            return willPlayerWin(b, "X");
        } for (int i = 0; i < 9; i++) {
            if (b.board.get(i) == " ") {
                return i;
            }
        } return -1;
    }

    public int play(Board b, String player){
        if (player == "X") {
            b.printBoard();
            if (b.gameOver(this)) {
                System.out.print("Game Over! Try again next time" + "\n");
            }

            System.out.print("Please choose a row" + "\n");
            valueAsker("row");

            System.out.print("Please choose a column" + "\n");
            valueAsker("col");

            int index = b.getIndex(row, col);
            if (b.board.get(index) != " ") {
                System.out.print("Square already taken try again" + "\n");
                play(b, "X");
            } b.setBoard(row, col, this);

            if (b.boardFull()){
                b.printBoard();
                System.out.print("Tie Game. Better luck next time." + "\n");
            } return play(b, "0");

        } else if (player == "O"){
            if (b.gameOver(this)) {
                b.printBoard();
                System.out.print("Game Over! Try again next time" + "\n");
            } int aiResponse = ai(b);
            b.setBoard(aiResponse/3, aiResponse%3, this);
            return play(b, "X");
        } return -1;
    }

}

