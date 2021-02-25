package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D7);
        assertThat(bishopBlack.position(), is(Cell.D7));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(D7);
        BishopBlack bishopBlackCopy = (BishopBlack) bishopBlack.copy(A7);
        assertThat(bishopBlackCopy.position(), is(A7));
    }

    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] rsl = bishopBlack.way(G5);
        Cell[] expected = new Cell[]{D2, E3, F4, G5};
        assertArrayEquals(rsl, expected);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void wayImpossible() {
        new BishopBlack(C1).way(G4);
    }

    @Test
    public void isDiagonal(){
        assertThat(new BishopBlack(C1).isDiagonal(A1, H8), is(true));
        assertThat(new BishopBlack(C1).isDiagonal(A1, F4), is(false));
    }
}