package game;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void ifPlayerXHas2XSInARowTheyShouldWinOnNextMove() {
        Board b = new Board();
        Player p = new Player();
        b.setBoard(0, 1, p);
        b.setBoard(0, 2, p);
        assertEquals(0, p.willPlayerWin(b,"X"));
    }

//    @Test
//    public void playingTheGame() {
//        Board b = new Board();
//        Player p = new Player();
//
//        assertEquals(p.play(b, "X"), -1);
//    }

    //I had to manually perform the functionality of the play() method here since
    //that's a recursive method that relies on user input
    @Test
    public void ifItIsTheAIsTurnItShouldMakeAStategicMove() {
        Board b = new Board();
        Player p = new Player();
        b.setBoard(1, 1, p);
        p.playerType = "O";
        int aiResponse = p.ai(b);
        b.setBoard(aiResponse/3, aiResponse%3, p);
        List<String> newBoard = Arrays.asList("O", " ", " ", " ", "X", " ", " ", " ", " ");
        assertEquals(newBoard, b.board);
    }

    @Test
    public void AIShouldBeAbleToWinTheGame() {

    }
}
