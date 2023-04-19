import calc.Core;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Dev3_Test {
    Core record = new Core(321f, 3213f,321f,321f, 3f);

    @Test
    public void value_check() {
        assertEquals(record.NB(), 321.0f, 0f);
    }
}
