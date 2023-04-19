import calc.CalcCore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Dev4_Test {

    CalcCore core_val_1 = new CalcCore(0f, 0f, 0f, 0f, 0f);

    // Тест на то, что все значения выводятся верно
    @Test
    public void value_check() {
        assertTrue(core_val_1.get_values() instanceof String);
        assertEquals(core_val_1.get_values(), "Core[NB=0.0, NS=0.0, PV=0.0, PK=0.0, L=0.0]");
    }
}
