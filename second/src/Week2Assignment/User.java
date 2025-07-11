package Week2Assignment;

public class User {

    int Id;
    String name;
    int age;

    User(int Id, String name, int age)
    {
        this.Id = Id;
        this.name = name;
        this.age = age;
    }

    void viewDetials()
    {
        System.out.println(this.Id);
        System.out.println(this.name);
    }
}

