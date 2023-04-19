import calc.CalcCore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Dev1_Test {

    CalcCore core_val_1 = new CalcCore(1f, 0f, 0f, 0f, 0f);
    CalcCore core_val_2 = new CalcCore(1f, 1f, 1f, 1f, 0f);
    CalcCore core_val_3 = new CalcCore(10f, 1f, 1f, 1f, 5f);

    // Тест формулы
    @Test
    public void value_check() {
        assertEquals(core_val_1.get_formula_value(), 0f, 0f);
        assertEquals(core_val_2.get_formula_value(), 1f, 0f);
        assertEquals(core_val_3.get_formula_value(), 5f, 0f);
    }
}
