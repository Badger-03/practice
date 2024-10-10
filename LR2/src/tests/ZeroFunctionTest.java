package tests;

import functions.MathFunction;
import functions.ZeroFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZeroFunctionTest {
    @Test
    public void testApply() {
        MathFunction zero = new ZeroFunction();
        assertEquals(0.0, zero.apply(-10.0), 1e-9);
        assertEquals(0.0, zero.apply(0.0), 1e-9);
        assertEquals(0.0, zero.apply(10.0), 1e-9);
    }
}
