package game;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BoardTest {
    @Test
    public void boardShouldBeEmptyUponInitialization() {
        Board newBoard = new Board();
        List<String> emptyBoard = Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        assertEquals(newBoard.getBoard(), emptyBoard);
    }
}
