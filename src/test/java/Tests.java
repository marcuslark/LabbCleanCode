import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import se.iths.labb.Cell;
import static org.junit.Assert.*;
import se.iths.labb.GameOfLife;
import javax.swing.*;
import static org.fest.assertions.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class Tests {
    @Test
    @Parameters({"ALIVE, 0, DEAD"})
    public void shouldDieWithZeroNeighbours(String initialState, int numberOfNeighbours, String expectedState){
        Cell testCell = new Cell(Cell.cellState.valueOf(initialState));

        Cell.cellState actual = testCell.getNextState(numberOfNeighbours);

        assertEquals(Cell.cellState.valueOf(expectedState), actual);
    }
    @Test
    public void shouldDieWIthOnlyOneNeighbour() {
        Cell uut = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = uut.getNextState(1);

        assertEquals(Cell.cellState.DEAD, actual);
    }
    @Test
    public void shouldStayAliveWithTwoNeighbours() {
        Cell testCell = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = testCell.getNextState(2);

        assertEquals(Cell.cellState.ALIVE, actual);
    }
    @Test
    public void shouldStayAliveWithThreeNeighbours() {
        Cell testCell = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = testCell.getNextState(3);

        assertEquals(Cell.cellState.ALIVE, actual);
    }
    @Test
    public void shouldDieWithFourNeighbours() {
        Cell testCell = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = testCell.getNextState(4);

        assertEquals(Cell.cellState.DEAD, actual);
    }
    @Test
    public void shouldDieWithFiveNeighbours() {
        Cell testCell = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = testCell.getNextState(5);

        assertEquals(Cell.cellState.DEAD, actual);
    }
    @Test
    public void shouldDieWithSixNeighbours() {
        Cell testCell = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = testCell.getNextState(6);

        assertEquals(Cell.cellState.DEAD, actual);
    }
    @Test
    public void shouldDieWithSevenNeighbours() {
        Cell testCell = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = testCell.getNextState(7);

        assertEquals(Cell.cellState.DEAD, actual);
    }
    @Test
    public void shouldDieWithEightNeighbours() {
        Cell testCell = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = testCell.getNextState(8);

        assertEquals(Cell.cellState.DEAD, actual);
    }
    @Test
    public void shouldBecomeAliveWithThreeNeighbours(){
        Cell testCell = new Cell(Cell.cellState.DEAD);

        Cell.cellState actual = testCell.getNextState(3);

        assertEquals(Cell.cellState.ALIVE, actual);
    }
}
