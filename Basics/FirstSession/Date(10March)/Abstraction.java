
abstract class Upper{
    int var = 10;
    abstract void prnt();
}

public class Abstraction extends Upper{

    public void prnt()
    {
        System.out.println(var);
    }

    void extraMethod()
    {
        System.out.println("exra");
    }
    
    public static void main(String [] args)
    {
        Abstraction a = new Abstraction();
        a.prnt();
        a.extraMethod();
        System.out.println("end");
    }
}