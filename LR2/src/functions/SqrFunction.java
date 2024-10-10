package functions;

/**
 * Класс функции возведения в квадрат.
 */
public class SqrFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return x * x;
    }
}
