package tests;

import functions.MathFunction;
import functions.SinFunction;
import functions.SqrFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathFunctionTest {
    @Test
    public void testAndThen() {
        MathFunction sin = new SinFunction();
        MathFunction sqr = new SqrFunction();

        // Используем метод andThen
        MathFunction sinThenSqr = sin.andThen(sqr);
        double x = 1.0;
        double expected = Math.pow(Math.sin(x), 2);
        assertEquals(expected, sinThenSqr.apply(x), 1e-9);

        // Цепочка andThen
        MathFunction composite = sin.andThen(sqr).andThen(sin);
        expected = Math.sin(Math.pow(Math.sin(x), 2));
        assertEquals(expected, composite.apply(x), 1e-9);
    }
}
