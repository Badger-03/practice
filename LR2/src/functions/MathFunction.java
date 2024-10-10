package functions;

/**
 * Интерфейс для математических функций.
 */
public interface MathFunction {
    /**
     * Применяет функцию к заданному значению x.
     *
     * @param x аргумент функции
     * @return значение функции в точке x
     */
    double apply(double x);

    /**
     * Возвращает композицию текущей функции с функцией afterFunction.
     *
     * @param afterFunction функция, применяемая после текущей
     * @return композиция функций
     */
    default MathFunction andThen(MathFunction afterFunction) {
        return new CompositeFunction(this, afterFunction);
    }
}
