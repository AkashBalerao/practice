// package lamdbaExp;
import java.util.function.*;

interface Innerfirst {
    void show();
}

public class lmdexp{

    int x = 0;
    void m1()
    {
        int y = 20;
        Innerfirst obj = () -> {
            System.out.println("Hello World");
            System.out.println("Value of x is: " + x);
            System.out.println("Value of y is: " + y);
            x=23;
        };
        obj.show();
    }
    public static void main(String[] args) {

        Function<String, String> f1=x->x.toUpperCase();
        Function<String, String> f2=x->{String p=""; 
        for(int i=0; i<x.length(); i++)
        {
            p += x.charAt(x.length()-i-1);
        }
        return p.replace(" ", "");
    };

        String k = f1.andThen(f2).apply("Hello World");
        System.out.println(k);

        lmdexp obj = new lmdexp();
        obj.m1();
        
    }
}