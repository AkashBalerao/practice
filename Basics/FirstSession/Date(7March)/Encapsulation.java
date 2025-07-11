import java.util.*;

class Bank
{
    private String name;
    private String phno;

    Bank(String name, String phno)
    {
        this.name = name;
        this.phno = phno;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }

    String getPhno()
    {
        return phno;
    }

    void setPhno(String phno)
    {
        this.phno = phno;
    }
}

class Encapsulation
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String [] args)
    {

        Bank b = new Bank("Akash", "7680060358");

        System.out.println("Name of customer: "+b.getName());
        System.out.println("Phno of customer: "+b.getPhno());

        int choice = 0;
        System.out.println("\nEnter 1 to change Name \nEnter 2 to change Phno\nEnter 3 to Exit\n");
        do{
            System.out.print("Your choice: ");
            choice = sc.nextInt();
        }while(choice!=1 && choice!=2 && choice!=3);

        if(choice==1)
        {
            System.out.println("Enter name you want to change to: ");
            String p = sc.next();
            b.setName(p);
            System.out.println("Name of customer: "+b.getName());
            System.out.println("Phno of customer: "+b.getPhno());
        }else if(choice == 2)
        {
            System.out.println("Enter phno you want to change to: ");
            String p = sc.next();
            b.setPhno(p);
            System.out.println("Name of customer: "+b.getName());
            System.out.println("Phno of customer: "+b.getPhno());
        }else{
            System.out.println("Thanks");
        }
    }
}