package tests;

import functions.ConstantFunction;
import functions.MathFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantFunctionTest {
    @Test
    public void testApply() {
        MathFunction constant = new ConstantFunction(5.0);
        assertEquals(5.0, constant.apply(-10.0), 1e-9);
        assertEquals(5.0, constant.apply(0.0), 1e-9);
        assertEquals(5.0, constant.apply(10.0), 1e-9);
    }

    @Test
    public void testGetConstant() {
        ConstantFunction constantFunction = new ConstantFunction(3.14);
        assertEquals(3.14, constantFunction.getConstant(), 1e-9);
    }
}
