package tests;

import functions.MathFunction;
import functions.SinFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinFunctionTest {
    @Test
    public void testApply() {
        MathFunction sin = new SinFunction();
        assertEquals(0.0, sin.apply(0.0), 1e-9);
        assertEquals(1.0, sin.apply(Math.PI / 2), 1e-9);
        assertEquals(0.0, sin.apply(Math.PI), 1e-9);
    }
}
