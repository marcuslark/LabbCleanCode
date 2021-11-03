import org.junit.Test;
import se.iths.labb.Cell;
import se.iths.labb.Universe;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UniverseTest {

    public static final Cell X = new Cell(Cell.cellState.ALIVE);
    public static final Cell O = new Cell(Cell.cellState.DEAD);

    @Test
    public void shouldStoreTheInitialState(){
        Cell[][] original = {
                {X, O, X},
                {O, O, O},
                {O, X, X},
        };
        Universe testUniverse = new Universe(original);

        Cell[][] actual = testUniverse.getState();
        assertArrayEquals(original, actual);

    }

    @Test
    public void shouldUpdateCell(){
        Universe testUniverse = new Universe(new Cell[][]{
                { X }
        });

        Cell[][] actual = getNextState(testUniverse);

        assertEquals(O, actual[0][0]);
    }

    @Test
    public void shouldUpdateAllCells() {
        Universe testUniverse = new Universe(new Cell[][] {
                { O, O, O, O, O, O, O, O },
                { O, O, O, O, X, O, O, O },
                { O, O, O, X, X, O, O, O },
                { O, O, O, O, O, O, O, O }
        });
        Cell[][] expected = new Cell[][] {
                { O, O, O, O, O, O, O, O },
                { O, O, O, X, X, O, O, O },
                { O, O, O, X, X, O, O, O },
                { O, O, O, O, O, O, O, O }
        };

        Cell[][] actual = getNextState(testUniverse);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldHaveMaximumNeighbours(){
        Universe testUniverse = new Universe(new Cell[][] {
                {X, X, X },
                {X, X, X },
                {X, X, X }
        });
        Cell[][] expected = new Cell[][] {
                { X, O, X },
                { O, O, O },
                { X, O, X }
        };

        Cell[][] actual = getNextState(testUniverse);
        assertArrayEquals(expected, actual);
    }

    private Cell[][] getNextState(Universe testUniverse) {
        testUniverse.update();
        return testUniverse.getState();
    }

}
