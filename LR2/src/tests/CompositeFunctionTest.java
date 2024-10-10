package tests;

import functions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeFunctionTest {
    @Test
    public void testApply() {
        MathFunction identity = new IdentityFunction();
        MathFunction sqr = new SqrFunction();
        MathFunction sin = new SinFunction();

        // Композиция sin(sqr(x))
        MathFunction sinSqr = new CompositeFunction(sqr, sin);
        assertEquals(Math.sin(Math.pow(2.0, 2)), sinSqr.apply(2.0), 1e-9);

        // Композиция sqr(sin(x))
        MathFunction sqrSin = new CompositeFunction(sin, sqr);
        assertEquals(Math.pow(Math.sin(2.0), 2), sqrSin.apply(2.0), 1e-9);

        // Композиция сложной функции с собой
        MathFunction composite = new CompositeFunction(sinSqr, sqrSin);
        double expected = sqrSin.apply(sinSqr.apply(2.0));
        assertEquals(expected, composite.apply(2.0), 1e-9);
    }
}
