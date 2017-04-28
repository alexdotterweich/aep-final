package game;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void boardShouldBeEmptyUponInitialization() {
        Board newBoard = new Board();
        List<String> emptyBoard = Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        assertEquals(newBoard.getBoard(), emptyBoard);
    }

    @Test
    public void boardShouldSetSquareR0C0() {
        Board newBoard = new Board();
        Player p = new Player();
        newBoard.setBoard(0, 0, p);
        List<String> boardFilledR0C0 = Arrays.asList("X", " ", " ", " ", " ", " ", " ", " ", " ");
        assertEquals(newBoard.getBoard(), boardFilledR0C0);
    }

    @Test
    public void boardShouldSetSquareR1C2() {
        Board newBoard = new Board();
        Player p = new Player();
        newBoard.setBoard(1, 2, p);
        List<String> boardFilledR1C2 = Arrays.asList(" ", " ", " ", " ", " ", "X", " ", " ", " ");
        assertEquals(newBoard.getBoard(), boardFilledR1C2);
    }

    @Test
    public void boardShouldSetSquareR2C1() {
        Board newBoard = new Board();
        Player p = new Player();
        newBoard.setBoard(2, 1, p);
        List<String> boardFilledR2C1 = Arrays.asList(" ", " ", " ", " ", " ", " ", " ", "X", " ");
        assertEquals(newBoard.getBoard(), boardFilledR2C1);
    }

    @Test
    public void gameShouldBeOverWhen3DiagonalXSLineUp() {
        Board newBoard = new Board();
        Player p = new Player();
        newBoard.setBoard(0, 0, p);
        newBoard.setBoard(1, 1, p);
        newBoard.setBoard(2, 2, p);
        assertTrue(newBoard.gameOver(p));
    }

    @Test
    public void gameShouldBeOverWhen3LinearXSLineUp() {
        Board newBoard = new Board();
        Player p = new Player();
        newBoard.setBoard(2, 0, p);
        newBoard.setBoard(2, 1, p);
        newBoard.setBoard(2, 2, p);
        assertTrue(newBoard.gameOver(p));
    }

    @Test
    public void gameShouldBeOverWhenBoardIsFull() {
        Board newBoard = new Board();
        Player p = new Player();
        newBoard.setBoard(0, 0, p);
        newBoard.setBoard(0, 1, p);
        newBoard.setBoard(0, 2, p);
        newBoard.setBoard(1, 0, p);
        newBoard.setBoard(1, 1, p);
        newBoard.setBoard(1, 2, p);
        newBoard.setBoard(2, 0, p);
        newBoard.setBoard(2, 1, p);
        newBoard.setBoard(2, 2, p);
        assertTrue(newBoard.boardFull());
    }
}
