package functions;

import java.util.Arrays;

/**
 * Класс табулированной функции на основе массива.
 */
public class ArrayTabulatedFunction extends AbstractTabulatedFunction {
    private final double[] xValues;
    private final double[] yValues;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length || xValues.length < 2) {
            throw new IllegalArgumentException("Массивы имеют разную длину или слишком малы.");
        }
        this.xValues = Arrays.copyOf(xValues, xValues.length);
        this.yValues = Arrays.copyOf(yValues, yValues.length);
        count = xValues.length;
        for (int i = 1; i < count; i++) {
            if (this.xValues[i] <= this.xValues[i - 1]) {
                throw new IllegalArgumentException("Значения x должны быть строго возрастающими.");
            }
        }
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count < 2) {
            throw new IllegalArgumentException("Количество точек должно быть не менее 2.");
        }
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        this.xValues = new double[count];
        this.yValues = new double[count];
        this.count = count;
        double step = (xTo - xFrom) / (count - 1);
        for (int i = 0; i < count; i++) {
            xValues[i] = xFrom + step * i;
            yValues[i] = source.apply(xValues[i]);
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        checkIndex(index);
        return xValues[index];
    }

    @Override
    public double getY(int index) {
        checkIndex(index);
        return yValues[index];
    }

    @Override
    public void setY(int index, double value) {
        checkIndex(index);
        yValues[index] = value;
    }

    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (xValues[i] == x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (yValues[i] == y) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double leftBound() {
        return xValues[0];
    }

    @Override
    public double rightBound() {
        return xValues[count - 1];
    }

    @Override
    protected int floorIndexOfX(double x) {
        if (x < xValues[0]) {
            return 0;
        }
        if (x > xValues[count - 1]) {
            return count - 1;
        }
        for (int i = 1; i < count; i++) {
            if (xValues[i] > x) {
                return i - 1;
            }
        }
        return count - 2;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, 0);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, count - 2);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        return interpolate(x, xValues[floorIndex], xValues[floorIndex + 1], yValues[floorIndex], yValues[floorIndex + 1]);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс вне границ.");
        }
    }
}
