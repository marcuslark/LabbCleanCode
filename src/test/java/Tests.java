import org.junit.Before;
import se.iths.labb.GameOfLife;
import static org.fest.assertions.Assertions.assertThat;
public class Tests {

    @Before
    public void before(){
        gameOfLife = new GameOfLife(4,8);
    }
}
