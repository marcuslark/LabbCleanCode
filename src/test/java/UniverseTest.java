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

        cellState[][] actual = getNextState(testUniverse);

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

        cellState[][] actual = getNextState(testUniverse);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldConsiderAllNeighbours(){
        Universe testUniverse = new Universe(new Cell.cellState[][] {
                {X, X, X },
                {X, X, X },
                {X, X, X }
        });
        Cell.cellState[][] expected = new Cell.cellState[][] {
                { X, O, X },
                { O, O, O },
                { X, O, X }
        };

        cellState[][] actual = getNextState(testUniverse);
        assertArrayEquals(expected, actual);
    }

    private cellState[][] getNextState(Universe testUniverse) {
        testUniverse.update();
        return testUniverse.getState();
    }

}
