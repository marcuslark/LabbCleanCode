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
        Universe universe = new Universe(original);

        Cell.cellState[][] actual = universe.getState();
        assertArrayEquals(original, actual);

    }

    @Test
    public void shouldUpdateCell(){
        Universe universe = new Universe(new cellState[][]{{X}});

        universe.update();
        cellState[][] actual = universe.getState();

        assertEquals(cellState.DEAD, actual[0][0]);
    }

}
