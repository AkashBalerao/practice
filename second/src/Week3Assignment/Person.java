package Week3Assignment;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public class Person implements Serializable{
	
	public static ArrayList<Person> passengers = new ArrayList<Person>();
	
	public static ConcurrentLinkedQueue<Integer> availableSeats = new ConcurrentLinkedQueue<>();
	
	
	private static int generateId;
	
	private int id;
	private String name;
	private int age;
	private boolean gender;
	private int seatno;
	
	static {
		Person p1 = new Person("Latha", 23, false);
		Person p2 = new Person("Akash", 24, true);
		Person p3 = new Person("Neha", 27, false);
		Person p4 = new Person("Rohan", 30, true);
		Person p5 = new Person("Priya", 22, false);
		Person p6 = new Person("Amit", 28, true);
		Person p7 = new Person("Sneha", 25, false);
		Person p8 = new Person("Kiran", 29, true);
		Person p9 = new Person("Meera", 26, false);
		Person p10 = new Person("Sandeep", 31, true);
//		Person p11 = new Person("Vikas", 21, false);
//		Person p12 = new Person("Ananya", 32, true);
//		Person p13 = new Person("Rahul", 27, false);
//		Person p14 = new Person("Divya", 23, true);
//		Person p15 = new Person("Ravi", 35, false);
//		Person p16 = new Person("Simran", 29, true);
//		Person p17 = new Person("Pooja", 24, false);
//		Person p18 = new Person("Manoj", 30, true);
//		Person p19 = new Person("Kavita", 28, false);
//		Person p20 = new Person("Arjun", 33, true);
		
		Person.addPassenger(p1);
        Person.addPassenger(p2);
        Person.addPassenger(p3);
        Person.addPassenger(p4);
        Person.addPassenger(p5);
        Person.addPassenger(p6);
        Person.addPassenger(p7);
        Person.addPassenger(p8);
        Person.addPassenger(p9);
        Person.addPassenger(p10);
//        Person.addPassenger(p11);
//        Person.addPassenger(p12);
//        Person.addPassenger(p13);
//        Person.addPassenger(p14);
//        Person.addPassenger(p15);
//        Person.addPassenger(p16);
//        Person.addPassenger(p17);
//        Person.addPassenger(p18);
//        Person.addPassenger(p19);
//        Person.addPassenger(p20);
        
        for (int i = 1; i <= 30; i++) {
            availableSeats.add(i);
        }
	}
	
	Person(){};
	
	Person(String name, int age, boolean gender)
	{
		this.id = ++generateId;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	int getId()
	{
		return id;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
	
	String getName()
	{
		return this.name;
	}
	
	void setAge(int newAge)
	{
		this.age = newAge;
	}
	
	int getAge()
	{
		return this.age;
	}
	
	void setGender(boolean gender)
	{
		this.gender = gender;
	}
	
	boolean getGender()
	{
		return this.gender;
	}
	
	void setSeatNo(int seatno)
	{
		this.seatno = seatno;
	}
	
	int getSeatNo()
	{
		return this.seatno;
	}
	
	public static void addPassenger(Person p)
	{
		passengers.add(p);
	}
	
	public Person run() throws Exception
	{
		
		Integer assignedSeat = availableSeats.poll(); 

        if (assignedSeat != null) {
            setSeatNo(assignedSeat);
            System.out.println(Thread.currentThread().getName() + " assigned Seat No: " + assignedSeat + " to " + name);
        } else {
            System.out.println(Thread.currentThread().getName() + " No seat available for " + name);
        }
        Thread.sleep(1000);
        
        return this;
	}
}
