package WEEK2.Week2Assignment;

public class Admin extends User{
    static int genId = 0;

    Admin(String name, int age){
        super(++genId, name, age);
    }

    public String toString()
    {
        return "Name: "+super.name+" age: "+super.age;
    }

    void viewDetials()
    {
        System.out.printf("%-10d %-20s %-10d\n", super.Id, this.name, this.age);
    }
}
