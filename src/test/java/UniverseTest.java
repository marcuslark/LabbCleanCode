import org.junit.Test;
import se.iths.labb.Cell;
import se.iths.labb.Universe;
import se.iths.labb.Cell.cellState;
public class UniverseTest {

    public static final cellState X = cellState.ALIVE;
    public static final cellState O = cellState.DEAD;

    @Test
    public void shouldStoreTheInitialState(){
       Universe universe = new Universe(new Cell.cellState[][] {
                {X, O, X},
                {O, O, O},
                {O, X, X},
        });
    }
}
