package tests;

import functions.ArrayTabulatedFunction;
import functions.MathFunction;
import functions.SqrFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTabulatedFunctionTest {
    @Test
    public void testConstructorAndGetters() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(3, function.getCount());
        assertEquals(1.0, function.getX(0), 1e-9);
        assertEquals(4.0, function.getY(1), 1e-9);
    }

    @Test
    public void testApply() {
        MathFunction sqrFunction = new SqrFunction();
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(sqrFunction, 0, 10, 11);

        assertEquals(25.0, function.apply(5.0), 1e-9); // Точка из таблицы
        assertEquals(30.25, function.apply(5.5), 1e-9); // Интерполяция
        assertEquals(0.0, function.apply(-5.0), 1e-9); // Экстраполяция влево
        assertEquals(100.0, function.apply(10.0), 1e-9); // Правая граница
        assertEquals(121.0, function.apply(11.0), 1e-9); // Экстраполяция вправо
    }

    @Test
    public void testSetY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {1.0, 4.0, 9.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        function.setY(1, 16.0);
        assertEquals(16.0, function.getY(1), 1e-9);
    }

    @Test
    public void testIndexOfX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {1.0, 4.0, 9.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(0, function.indexOfX(1.0));
        assertEquals(-1, function.indexOfX(4.0));
    }

    @Test
    public void testIndexOfY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {1.0, 4.0, 9.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(1, function.indexOfY(4.0));
        assertEquals(-1, function.indexOfY(5.0));
    }
}
