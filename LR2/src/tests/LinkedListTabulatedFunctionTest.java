package tests;

import functions.LinkedListTabulatedFunction;
import functions.MathFunction;
import functions.SinFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTabulatedFunctionTest {
    @Test
    public void testConstructorAndGetters() {
        double[] xValues = {0.0, Math.PI / 2, Math.PI};
        double[] yValues = {0.0, 1.0, 0.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        assertEquals(3, function.getCount());
        assertEquals(0.0, function.getX(0), 1e-9);
        assertEquals(1.0, function.getY(1), 1e-9);
    }

    @Test
    public void testApply() {
        MathFunction sinFunction = new SinFunction();
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(sinFunction, 0, Math.PI, 5);

        assertEquals(0.0, function.apply(0.0), 1e-9); // Точка из таблицы
        assertEquals(1.0, function.apply(Math.PI / 2), 1e-9); // Точка из таблицы
        assertEquals(Math.sin(Math.PI / 4), function.apply(Math.PI / 4), 1e-9); // Интерполяция
        assertEquals(0.0, function.apply(-Math.PI), 1e-9); // Экстраполяция влево
        assertEquals(0.0, function.apply(2 * Math.PI), 1e-9); // Экстраполяция вправо
    }

    @Test
    public void testSetY() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        function.setY(1, 2.0);
        assertEquals(2.0, function.getY(1), 1e-9);
    }

    @Test
    public void testIndexOfX() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        assertEquals(1, function.indexOfX(1.0));
        assertEquals(-1, function.indexOfX(3.0));
    }

    @Test
    public void testIndexOfY() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        assertEquals(2, function.indexOfY(4.0));
        assertEquals(-1, function.indexOfY(5.0));
    }
}
