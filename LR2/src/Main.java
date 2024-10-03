import functions.FunctionPoint;
import functions.TabulatedFunction;

public class Main {
    public static void main(String[] args) {
        // Создаем табулированную функцию от 0 до 10 с 5 точками
        TabulatedFunction func = new TabulatedFunction(0, 10, 5);

        // Выводим точки функции
        System.out.println("Точки табулированной функции:");
        for (int i = 0; i < func.getPointsCount(); i++) {
            System.out.println(func.getPoint(i));
        }

        // Получаем значение функции в точке 5
        System.out.println("\nЗначение функции в точке 5: " + func.getFunctionValue(5));

        // Добавляем новую точку
        func.addPoint(new FunctionPoint(7.5, 3));
        System.out.println("\nПосле добавления новой точки:");
        System.out.println(func);

        // Удаляем точку
        func.deletePoint(1);
        System.out.println("\nПосле удаления второй точки:");
        System.out.println(func);
    }
}
