import java.util.*;

class Ifelse
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String [] args)
    {
        System.out.println("Enter integer a: ");
        int a = sc.nextInt();
        System.out.println("Enter integer b: ");
        int b = sc.nextInt();

        if(a > b)
        {
            System.out.println("a is greater than b");
        }else if(b > a)
        {
            System.out.println("b is greater than a");
        }else{
            System.out.println("a is equal to b");
        }

        // if(false)
        // {
        //     equalTo:
        //         System.out.println("they are equal");
        // }else{
        //     if(a>b)
        //     {
        //         System.out.println("a > b");
        //     }else if(a<b){
        //         System.out.println("a < b");
        //     }else{
        //         continue equalTo;
        //     }
        // }
    }
}