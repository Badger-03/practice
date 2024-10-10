package tests;

import functions.MathFunction;
import functions.SqrFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqrFunctionTest {
    @Test
    public void testApply() {
        MathFunction sqr = new SqrFunction();
        assertEquals(0.0, sqr.apply(0.0), 1e-9);
        assertEquals(25.0, sqr.apply(5.0), 1e-9);
        assertEquals(9.8596, sqr.apply(-3.14), 1e-4);
    }
}
