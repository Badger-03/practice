package functions;

/**
 * Класс синусоидальной функции.
 */
public class SinFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.sin(x);
    }
}
