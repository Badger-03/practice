package functions;

/**
 * Класс тождественной функции.
 */
public class IdentityFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return x;
    }
}
