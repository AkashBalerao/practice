import java.util.*;
import java.util.function.*;

public class Ccuts {
    // public static void main(String[] args) {
    //     Random rand = new Random();
    //     List<Integer> a = new ArrayList<>();
    //     a.add(3);
    //     a.add(23);
    //     a.add(87);
    //     a.add(7);
    //     a.add(5);
    //     System.out.println("a: "+a);
    //     Collections.sort(a);
    //     System.out.println("a: "+a);

    //     // Collections.reverse(a);
    //     // System.out.println(a);

    //     // Collections.shuffle(a);
    //     // System.out.println(a);

    //     // System.out.println(Collections.min(a)+" "+Collections.max(a));

    //     System.out.println(Collections.binarySearch(a, 23));
    //     Collections.fill(a, 1);
    //     System.out.println("a: "+a);
    //     List<Integer> b = new ArrayList<>(Collections.nCopies(a.size(), null));
    //     Collections.copy(b, a);
    //     System.out.println("b: "+b);
    //     // for(int i=0; i<a.size(); i++)
    //     // {
    //     //     a.set(i, rand.nextInt());
    //     // }
    //     // System.out.println("a: "+a);
    //     System.out.println(Collections.disjoint(a, b));

    //     List<Integer> c = Collections.unmodifiableList(a);
    //     System.out.println(c);
    //     // c.add(0);
    //     // System.out.println(c);

    //     List<Integer> d = Collections.synchronizedList(new ArrayList());
    //     // List<Integer> d = new ArrayList<>();

    //     Thread t1 = new Thread(()->{
    //         for(int i=0; i<2000; i++)
    //         {
    //             d.add(i);
    //         }
    //     });

    //     Thread t2 = new Thread(()->{
    //         for(int i=0; i<2000; i++)
    //         {
    //             d.add(2);
    //         }
    //     });

    //     t1.start();
    //     t2.start();

    //     try {
    //         t1.join();
    //         t2.join();
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }

    //     System.out.println("d size "+d.size());

    // }

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
