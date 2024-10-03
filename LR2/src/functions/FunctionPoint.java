package functions;

public class FunctionPoint {
    private double x; // Координата по оси X
    private double y; // Координата по оси Y

    // Конструктор для задания координат точки
    public FunctionPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Конструктор для копирования другой точки
    public FunctionPoint(FunctionPoint point) {
        this.x = point.x;
        this.y = point.y;
    }

    // Конструктор по умолчанию
    public FunctionPoint() {
        this(0, 0); // По умолчанию точка с координатами (0, 0)
    }

    // Геттеры и сеттеры для координат
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Переопределение метода toString() для удобного вывода
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
