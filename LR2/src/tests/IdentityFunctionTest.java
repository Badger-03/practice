package tests;

import functions.IdentityFunction;
import functions.MathFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdentityFunctionTest {
    @Test
    public void testApply() {
        MathFunction identity = new IdentityFunction();
        assertEquals(0.0, identity.apply(0.0), 1e-9);
        assertEquals(5.0, identity.apply(5.0), 1e-9);
        assertEquals(-3.14, identity.apply(-3.14), 1e-9);
    }
}
