package tests;

import functions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeTabulatedFunctionTest {
    @Test
    public void testCompositeWithTabulatedFunctions() {
        MathFunction sinFunction = new SinFunction();
        TabulatedFunction tabulatedSin = new ArrayTabulatedFunction(sinFunction, 0, Math.PI, 5);

        MathFunction sqrFunction = new SqrFunction();
        TabulatedFunction tabulatedSqr = new LinkedListTabulatedFunction(sqrFunction, 0, 2, 5);

        // Композиция табулированных функций
        MathFunction compositeFunction = tabulatedSin.andThen(tabulatedSqr);

        double x = Math.PI / 4;
        double expected = Math.pow(Math.sin(x), 2);
        assertEquals(expected, compositeFunction.apply(x), 1e-4);
    }
}
