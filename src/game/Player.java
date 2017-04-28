package game;
import java.util.Scanner;

// Understands how to play the game in the command line
public class Player {

    String playerType = "X";

    public Player() {

    }

    public int valueAsker(String colOrRow) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Choose the " + colOrRow + " you would like to select from 0 - 2" + "\n");
        int userValue = reader.nextInt();
        if ((userValue < 0) || (userValue > 2)) {
            System.out.print("Value out of range, please try again" + "\n");
            return valueAsker(colOrRow);
        }
        return userValue;
    }

    public String playerOpposite() {
        if (playerType == "X") {
            return "O";
        } return "X";
    }
//
//    Board.board.gameOver()
//
//    public void gameFinished() {
//        if (Board.board.gameOver())
//    }


}

