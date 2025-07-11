package lamdbaExp;

interface left {
    default void m1(){
        System.out.println("left");
    };
}

interface right {
    default void m1()
    {
        System.out.println("right");
    };
}
public class defMethd implements left, right {

    public void m1()
    {
        left.super.m1();
    }

    public static void main(String[] args) {
        defMethd obj = new defMethd();
        obj.m1();
    }
}
