package Week2Assignment;

import java.util.*;

enum subs{
    telugu,hindi,english,maths,physics,chem;
};

public class Student extends User{
    static int genId = -1;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10d %-20s %-10d ", super.Id, super.name, super.age));
        for (int grade : grades) {
            sb.append(String.format("%-10d", grade));
        }
        sb.append(String.format("%-9d%%\n", this.getGrade())); 

        return sb.toString();
    }


    int [] grades;

    Student(String name, int age, int [] g){
        super(++genId, name, age);
        this.grades = g;
    }

    @Override
    void viewDetials() {
        System.out.printf("%-10d %-20s %-10d ", super.Id, super.name, super.age);
        
        for (int grade : grades) {
            System.out.printf("%-10d", grade);
        }

        System.out.printf("%-10d", getGrade());
        System.out.println();
    }

    void displayRemarks()
    {
        int cgpa = getGrade();
        if(cgpa>=75)
        {
            System.out.println("Distinction");
        }else if(cgpa>=60 && cgpa<75)
        {
            System.out.println("First Class");
        }else if(cgpa>=50 && cgpa<59)
        {
            System.out.println("Second Class");
        }else if(cgpa>35 && cgpa<=49)
        {
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }

    int getGrade()
    {
        int avg = 0;
        for(int i=0; i<grades.length; i++)
        {
            avg+=grades[i];
        }
        return avg/grades.length;
    }
}
