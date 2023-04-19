
import calc.CalcCore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Dev3_Test {

    float value = 10f;
    CalcCore core = new CalcCore(0f, 0f, 0f, 0f, 0f);

    // Тест валидаторов
    @Test
    public void not_negative() {
        assertTrue(core.not_negative(value));
    }

    @Test
    public void not_large() {
        assertTrue(core.not_large(value));
    }
}
