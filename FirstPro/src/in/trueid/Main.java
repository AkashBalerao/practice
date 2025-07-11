package in.trueid;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
	 public static void main(String [] args)
	    {
	        Function<Integer, Integer> f = x->x+2;

	        Function<Integer, Integer> f2 = f.andThen(y->y*y);

	        System.out.println(f2.apply(2));

	        Consumer<String> print = s->System.out.println(s);

	        print.accept("hello");

	        BiConsumer<String , Integer> nameage  = (name, age)->{System.out.println(name+" "+age);};

	        nameage.accept("akash", 22);

	        Supplier<Integer> randomInt = () -> new Random().nextInt(100);

	        System.out.println(randomInt.get());

	        Predicate<Integer> evenOrOdd = x->x%2==0;

	        System.out.println(evenOrOdd.test(34));

	        BiPredicate<Integer, Integer> idVal = (a, b)->(a+b)%2==0;

	        System.out.println(idVal.test(23, 34));

	        UnaryOperator<Integer> sqar = x -> x*x;

	        System.out.println(sqar.apply(9));

	        BinaryOperator<Integer> sum = (a, b) -> a + b;

	        System.out.println(sum.apply(2, 4));
	    }

}
