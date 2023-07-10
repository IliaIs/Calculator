import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> isPositive.test(y) ? x / y : 0;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    /*
    Ошибка возникает из-за невозможности деления на 0.
    Проблему можно решить:

    1.Тернарным оператором(Так как сделал я)

    2.Блоком try/catch:
    BinaryOperator<Integer> devide = (x, y) -> {
        try {
            if (!isPositive.test(y)) {
                throw new ArithmeticException("На ноль делить нельзя");
            }
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println(e);
            return 0;
        }
    };

    3.Блоком if/else:
    BinaryOperator<Integer> devide = (x, y) -> {
        if (isPositive.test(y)) {
            return x / y;
        } else {
            return 0;
        }
    };
     */
}
