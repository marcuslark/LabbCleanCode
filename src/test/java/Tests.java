import org.junit.Test;
import se.iths.labb.Cell;
import static org.junit.Assert.*;
import se.iths.labb.GameOfLife;
import static org.fest.assertions.Assertions.assertThat;
public class Tests {
    @Test
    public void shouldDieWIthOnlyOneNeighbour() {
        Cell uut = new Cell(Cell.cellState.ALIVE);

        Cell.cellState actual = uut.getNextState(1);

        assertEquals(Cell.cellState.DEAD, actual);
    }

    @Test
    public void shouldDieWithZeroNeighbours(){
        Cell testCell = new Cell(Cell.cellState.ALIVE);
        
        Cell.cellState actual = testCell.getNextState(0);
        
        assertEquals(Cell.cellState.DEAD, actual);
    }


}
