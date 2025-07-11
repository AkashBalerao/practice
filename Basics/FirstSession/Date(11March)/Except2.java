
public class Except2 {

    // public static void f1() throws InterruptedException
    // {
    //     Thread.sleep(1000);
    //     System.out.println("After sleep");
    // }

    public static void f2()
    {
        f2();
    }
    public static void main(String [] args) {
        // try{
        //     f1();
        // }catch(InterruptedException e)
        // {
        //     System.out.println(e);
        // }

        try{
            f2();
        }catch(Error e)
        {
            System.out.println("83");
        }

    }
}
