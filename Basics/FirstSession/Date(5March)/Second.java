import java.util.Date;
import java.awt.*;
import java.util.*;

class Obj {
    int length;
}

class Second{
    public static void main(String [] args)
    {
        System.out.println("Operator Precedence");
        int x = 1, y = 2, z = 3;
        int a = x + y - 2/2 + z;
        int b = x + (y - 2)/(2 + z);
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println("------------------");
        System.out.println("Assignment");
        Obj obj1 = new Obj();
        Obj obj2 = new Obj();
        obj1.length = 4;
        obj2.length = 5;
        System.out.println("Obj1 length "+obj1.length+" \nObj2 length "+obj2.length);
        obj2 = obj1;
        System.out.println("Obj1 length "+obj1.length+" \nObj2 length "+obj2.length);

        System.out.println("------------------");
        System.out.println("Operations");
        int aN = 53;
        int bN = 23;
        System.out.println("a: "+aN);
        System.out.println("b: "+bN);
        System.out.println("a+b: "+(aN+bN));
        System.out.println("a-b: "+(aN-bN));
        System.out.println("a*b: "+(aN*bN));
        System.out.println("a/b: "+(aN/bN));
        System.out.println("a%b: "+(aN%bN));

        System.out.println("------------------");
        System.out.println("Increment and Decrement");
        int iN=5;
        System.out.println(iN++ + " "+ iN);
        System.out.println(++iN + " " + iN);
        System.out.println(iN-- + " " + iN);
        System.out.println(--iN + " " + iN);

        System.out.println("------------------");
        System.out.println("Relational Operators");
        Integer cN = Integer.valueOf(200);
        Integer dN = Integer.valueOf(200);
        System.out.println(cN == dN);
        System.out.println(cN.equals(dN));
        System.out.println(cN>=dN? "cN > dN" : "dN > cN");

        System.out.println("------------------");
        System.out.println("Logical operators");
        System.out.println("t && f:"+(true && false));
        System.out.println("f && f:"+(false && false));
        System.out.println("t && t:"+(true && true));

        System.out.println("t || f:"+(true || false));
        System.out.println("f || f:"+(false || false));
        System.out.println("t || t:"+(true || true));

        System.out.println("------------------");
        System.out.println("Bitwise Operations");
        System.out.println("First: "+Integer.toBinaryString(0xAA));
        System.out.println("First: "+Integer.toBinaryString(0x55));
        System.out.println(Integer.toBinaryString(0xAA & 0x55));
        System.out.println(Integer.toBinaryString(0xAA | 0x55));
        System.out.println(Integer.toBinaryString(0xAA ^ 0x55));
    }
}