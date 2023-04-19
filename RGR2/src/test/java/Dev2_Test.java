import calc.CalcCore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class Dev2_Test {

    CalcCore core = new CalcCore(1f, 5f, 7f, 8f, 4f);
    float value = 10f;
    // Тест, что каждое значение равно ожидаемому
    @Test
    public void get_every_value_test() {
        assertEquals(core.get_values(0), 1f, 0f);
        assertEquals(core.get_values(1), 5f, 0f);
        assertEquals(core.get_values(2), 7f, 0f);
        assertEquals(core.get_values(3), 8f, 0f);
        assertEquals(core.get_values(4), 4f, 0f);
        assertNull(core.get_values(5));
    }

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
