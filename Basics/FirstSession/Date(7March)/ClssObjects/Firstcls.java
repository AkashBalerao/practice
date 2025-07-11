
class Book implements Cloneable
{
    String name ;
    int noOfPages = 0;
    String author;

    Book(){}

    Book(String name, int s)
    {
        this.name = name;
        noOfPages = s;
    }

    Book(String name, int s, String author)
    {
        this.name = name;
        noOfPages = s;
        this.author = author;
    }

    public String toString()
    {
        return "Name: "+name+" "+"NoOfPages: "+ noOfPages;
    }

    // public boolean equals(Object b)
    // {
    //     Book B = (Book) b;
    //     if(B.name == this.name && B.noOfPages == this.noOfPages && B.author == this.author)
    //     {
    //         return true;
    //     }
    //     return false;
    // }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Firstcls
{
    public static void main(String [] args) throws CloneNotSupportedException
    {
        Book b = new Book("OKGO", 20);
        Book b2 = new Book("TKYT", 200, "Samuel");
        Book b3 = b;

        System.out.println(b);
        System.out.println(b.equals(b3));

        Book b4 = (Book) b.clone();

        System.out.println(b == b4);
        System.out.println(b.equals(b4));
    }
}