package firstpackage;

public class firstclass {
    int a = 10;
    public static void main(String [] args)
    {
        firstclass obj = new firstclass();
        System.out.println(obj.a);
    }
}

class Otherclass
{
    firstclass obj = new firstclass();

    void prnt()
    {
        System.out.println(obj.a);
    }
}
