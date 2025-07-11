import java.util.*;

class InsufficentBalance extends RuntimeException
{
    InsufficentBalance(String msg)
    {
        super(msg);
    }
}

class Bank
{
    double balance;
    String name;

    Bank(double bal, String name)
    {
        this.balance = bal;
        this.name = name;
    }

    void withdraw(int amt) throws InsufficentBalance
    {
        if(amt>balance)
        {
            throw new InsufficentBalance("jdij");
        }
        balance -= amt;
        System.out.println("balance: "+ balance);
    }
}

public class Exceptn {
    static Scanner sc = new Scanner(System.in);
    public static void main(String [] args)
    {
        Bank b = new Bank(10000, "akash");

        // try{
            int amt = sc.nextInt();
            b.withdraw(amt);
        // }catch(InsufficentBalance e)
        // {
        //     System.out.println(e);
        // }catch(InputMismatchException ime)
        // {
        //     System.out.println(ime.getMessage());
        // }finally{
        //     System.out.println("thank you");
        // }
    }
}
