import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> f1 = bind((a, b) -> a * b, 2);
        System.out.println(f1.apply(5));
        Function<String, String> f2 = bind((a, b) -> b.substring(0, a), 5);
        System.out.println(f2.apply("1234567899"));
        Function<String, String> sayHello = saySmth("Hello");
        System.out.println(sayHello.apply("Alice")); // Выведет "Hello, Alice!"
    }

    public static Function<String, String> saySmth(String word) {
        return bind((a, b) -> a + ", " +  b, word);
    }
    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }

    static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn){
        return a -> b -> fn.apply(a, b);
    }
}