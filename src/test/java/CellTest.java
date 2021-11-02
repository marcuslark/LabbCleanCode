import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import se.iths.labb.Cell;
import static org.junit.Assert.*;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CellTest {
    @Test
    @Parameters({
            "ALIVE, 0, DEAD",
            "ALIVE, 1, DEAD",
            "ALIVE, 2, ALIVE",
            "ALIVE, 3, ALIVE",
            "ALIVE, 4, DEAD",
            "ALIVE, 5, DEAD",
            "ALIVE, 6, DEAD",
            "ALIVE, 7, DEAD",
            "ALIVE, 8, DEAD",
            "DEAD, 0, DEAD",
            "DEAD, 1, DEAD",
            "DEAD, 2, DEAD",
            "DEAD, 3, ALIVE",
            "DEAD, 4, DEAD",
            "DEAD, 5, DEAD",
            "DEAD, 6, DEAD",
            "DEAD, 7, DEAD",
            "DEAD, 8, DEAD",})

    public void shouldCheckIfAllTheRulesIsWorking(String initial, int numberOfNeighbours, String expected){
        Cell.cellState initialState = Cell.cellState.valueOf(initial);
        Cell testCell = new Cell(initialState);

        Cell.cellState actual = testCell.getNextState(numberOfNeighbours);

        Cell.cellState expectedState = Cell.cellState.valueOf(expected);
        assertEquals(expectedState, actual);
    }
    @Test
    @Parameters({"ALIVE", "DEAD"})
    public void shouldReturnTheCellsState(String initial) {

        Cell.cellState original = Cell.cellState.valueOf(initial);
        Cell testCell = new Cell(original);

        assertEquals(original, testCell.getState());
    }
}
