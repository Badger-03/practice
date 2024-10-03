package functions;

import java.util.Arrays;

public class TabulatedFunction {
    private FunctionPoint[] points; // Массив точек
    private int pointsCount; // Количество точек

    // Конструктор с указанием границ и количества точек
    public TabulatedFunction(double leftX, double rightX, int pointsCount) {
        this.pointsCount = pointsCount;
        points = new FunctionPoint[pointsCount];
        double step = (rightX - leftX) / (pointsCount - 1); // Равномерное распределение точек
        for (int i = 0; i < pointsCount; i++) {
            points[i] = new FunctionPoint(leftX + i * step, 0); // По умолчанию значение функции (y) равно 0
        }
    }

    // Конструктор с указанием массива значений функции
    public TabulatedFunction(double leftX, double rightX, double[] values) {
        this.pointsCount = values.length;
        points = new FunctionPoint[pointsCount];
        double step = (rightX - leftX) / (pointsCount - 1);
        for (int i = 0; i < pointsCount; i++) {
            points[i] = new FunctionPoint(leftX + i * step, values[i]);
        }
    }

    // Метод для получения левой границы
    public double getLeftDomainBorder() {
        return points[0].getX();
    }

    // Метод для получения правой границы
    public double getRightDomainBorder() {
        return points[pointsCount - 1].getX();
    }

    // Метод для получения значения функции в точке x с линейной интерполяцией
    public double getFunctionValue(double x) {
        if (x < getLeftDomainBorder() || x > getRightDomainBorder()) {
            return Double.NaN; // Если x за пределами области определения
        }
        for (int i = 0; i < pointsCount - 1; i++) {
            if (x == points[i].getX()) {
                return points[i].getY();
            } else if (x > points[i].getX() && x < points[i + 1].getX()) {
                // Линейная интерполяция
                double x1 = points[i].getX();
                double y1 = points[i].getY();
                double x2 = points[i + 1].getX();
                double y2 = points[i + 1].getY();
                return y1 + (x - x1) * (y2 - y1) / (x2 - x1);
            }
        }
        return Double.NaN;
    }

    // Метод для получения количества точек
    public int getPointsCount() {
        return pointsCount;
    }

    // Метод для получения точки по индексу
    public FunctionPoint getPoint(int index) {
        if (index >= 0 && index < pointsCount) {
            return points[index];
        }
        return null;
    }

    // Метод для замены точки по индексу
    public void setPoint(int index, FunctionPoint point) {
        if (index >= 0 && index < pointsCount) {
            points[index] = point;
            Arrays.sort(points, (p1, p2) -> Double.compare(p1.getX(), p2.getX())); // Сортировка массива по X
        }
    }

    // Методы для работы с координатами X и Y точек
    public double getPointX(int index) {
        if (index >= 0 && index < pointsCount) {
            return points[index].getX();
        }
        return Double.NaN; // Если индекс неверный, возвращаем NaN
    }

    public void setPointX(int index, double x) {
        if (index >= 0 && index < pointsCount) {
            double y = points[index].getY();
            points[index] = new FunctionPoint(x, y);
            Arrays.sort(points, (p1, p2) -> Double.compare(p1.getX(), p2.getX())); // Сортировка по X после изменения
        }
    }

    public double getPointY(int index) {
        if (index >= 0 && index < pointsCount) {
            return points[index].getY();
        }
        return Double.NaN;
    }

    public void setPointY(int index, double y) {
        if (index >= 0 && index < pointsCount) {
            double x = points[index].getX();
            points[index] = new FunctionPoint(x, y);
        }
    }

    // Добавление и удаление точек
    public void addPoint(FunctionPoint point) {
        points = Arrays.copyOf(points, pointsCount + 1);
        points[pointsCount] = point;
        pointsCount++;
        Arrays.sort(points, (p1, p2) -> Double.compare(p1.getX(), p2.getX())); // Сортировка массива по X
    }

    public void deletePoint(int index) {
        if (index >= 0 && index < pointsCount) {
            FunctionPoint[] newPoints = new FunctionPoint[pointsCount - 1];
            System.arraycopy(points, 0, newPoints, 0, index);
            System.arraycopy(points, index + 1, newPoints, index, pointsCount - index - 1);
            points = newPoints;
            pointsCount--;
        }
    }

    // Переопределение метода toString() для вывода функции
    @Override
    public String toString() {
        return Arrays.toString(points);
    }
}
