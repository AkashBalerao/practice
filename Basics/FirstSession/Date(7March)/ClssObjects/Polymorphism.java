
class Animal
{
    void sound()
    {
        System.out.println("Animal Sound");
    }
}

class Dog extends Animal{
    void sound()
    {
        System.out.println("Dog bark");
    }

    void sound(String k)
    {
        System.out.println("Dog makes sound: "+k);
    }
}

class Retriver extends Dog{
    void sound()
    {
        System.out.println("Retriver");
    }
}

public class Polymorphism
{

    public static void main(String [] args)
    {
        Animal a = new Retriver();
        System.out.println(a.getClass());
        System.out.println(a.getClass().getSuperclass());
        System.out.println(a.getClass().getSuperclass().getSuperclass());
        System.out.println(a.getClass().getSuperclass().getSuperclass().getSuperclass());
        
        System.out.println(a instanceof Animal);
    }
}



// class Book
// {
//     String name;
//     String author;

//     void display()
//     {
//         System.out.println("Name :"+name+"\nAuthor :"+author);
//     }
// }

// class Fictions extends Book
// {
//     void display()
//     {
//         System.out.println("Name :"+name+"\nAuthor :"+author+"\nType :Fiction");
//     }
// }

// class NonFictions extends Book
// {
//     void display()
//     {
//         System.out.println("Name :"+name+"\nAuthor :"+author+"\nType :NonFiction");
//     }
// }

// class Fantasy extends Book
// {
//     void display()
//     {
//         System.out.println("Name :"+name+"\nAuthor :"+author+"\nType :Fantasy");
//     }
// }

// class Polymorphism
// {
//     public static void main(String [] args)
//     {
        
//     }
// }