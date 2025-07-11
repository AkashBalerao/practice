package Exceptions;

class myException extends Exception
{
    myException(String msg)
    {
        super(msg);
    }
}

public class Except {
    // public static int f1()
    // {
    //     try{
    //         System.out.println("outer");
    //         try{
    //             System.out.println("inner");
    //             System.out.println(1/0);
    //         }catch(NullPointerException ae)
    //         {
    //             System.out.println(ae);
    //         }finally{
    //             System.out.println("inner finnally");
    //         }
    //     }catch(Exception e){
    //         System.out.println("uyu");
    //     }finally{
    //         System.out.println("outter finally");
    //     }
    //     return 1;
    // }

    public static void f2()
    {

    }

    public static void func() throws myException
    {
        int a = 10;
        int b = 1;
        try{
            if(a==b)
            {
                System.out.println(10/0);
            }else{
                throw new myException("myexception");
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String [] args) throws Exception
    {
        // int a = 10;
        // int b = 0;
        // try{
        //     func();
        // }catch(Exception e)
        // {
        //     System.out.println(e.getMessage());
        // }finally{
        //     System.out.println("End");
        // }

        // try{
        //     System.out.println(10/0);
        // }catch(Exception e)
        // {
        //     System.out.println("Exception");
        // }catch(ArithmeticException ae)
        // {
        //     System.out.println("Ar Exception");
        // }

        // try{
        //     System.out.println("try");
        //     System.out.println(10/0);
        // }catch(NullPointerException e)
        // {
        //     System.out.println("exception");
        // }finally{
        //     System.out.println("end");
        // }

        f2();
    }
}
