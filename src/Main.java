import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> f2 = bind((a, b) -> a * b, 2);
        System.out.println(f2.apply(12));
    }
    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }

    static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn){
        return a -> b -> fn.apply(a, b);
    }
}