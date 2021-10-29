import org.junit.Test;
import se.iths.labb.Cell;
import static org.junit.Assert.*;
import se.iths.labb.GameOfLife;
import static org.fest.assertions.Assertions.assertThat;
public class Tests {
    @Test
    public void shouldDieWithZeroNeighbours(){
        Cell testCell = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = testCell.getNextState(0);

        assertEquals(Cell.cellState.DEAD, actual);
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
}
