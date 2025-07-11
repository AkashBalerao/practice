import java.util.function.*;

public class BuiltIn {
    public static void main(String[] args) {
        Predicate<Integer> f = x -> x > 10;
        System.out.println(f.test(4));
    }
}
