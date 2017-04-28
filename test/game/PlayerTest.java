package game;

import org.junit.Test;
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

}
