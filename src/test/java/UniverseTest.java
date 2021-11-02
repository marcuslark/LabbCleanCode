import org.junit.Test;
import se.iths.labb.Cell;
import se.iths.labb.Universe;
import se.iths.labb.Cell.cellState;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
public class UniverseTest {

    public static final cellState X = cellState.ALIVE;
    public static final cellState O = cellState.DEAD;

    @Test
    public void shouldStoreTheInitialState(){
        cellState[][] original = {
                {X, O, X},
                {O, O, O},
                {O, X, X},
        };
        Universe testUniverse = new Universe(original);

        Cell.cellState[][] actual = testUniverse.getState();
        assertArrayEquals(original, actual);

    }

    @Test
    public void shouldUpdateCell(){
        Universe testUniverse = new Universe(new cellState[][]{{X}});

        testUniverse.update();
        cellState[][] actual = testUniverse.getState();

        assertEquals(cellState.DEAD, actual[0][0]);
    }

    @Test
    public void shouldUpdateAllCells() {
        Universe testUniverse = new Universe(new Cell.cellState[][] {
                {O, X, X },
                {X, O, X },
                {O, O, X }
        });
        Cell.cellState[][] expected = new Cell.cellState[][] {
                { O, X, X },
                { O, O, X },
                { O, X, O }
        };

        testUniverse.update();
        Cell.cellState[][] actual = testUniverse.getState();
        assertArrayEquals(expected, actual);
    }

}
