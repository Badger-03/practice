package tests;

import functions.MathFunction;
import functions.UnitFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitFunctionTest {
    @Test
    public void testApply() {
        MathFunction unit = new UnitFunction();
        assertEquals(1.0, unit.apply(-10.0), 1e-9);
        assertEquals(1.0, unit.apply(0.0), 1e-9);
        assertEquals(1.0, unit.apply(10.0), 1e-9);
    }
}
