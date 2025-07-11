package DesignPatterns;

import java.util.*;

interface Student{
	void display(String cls);
}

class StudentType implements Student{
	
	private String name;
	private String roll;
	
	StudentType(String name, String roll)
	{
		this.name = name;
		this.roll = roll;
	}
	
	public void display(String cls)
	{
		System.out.println("Student name: "+name+" roll: "+roll+" class: "+cls);
	}
}

class StudentFactory{
	
	private static final Map<String, StudentType> li = new HashMap<>();
	
	public static StudentType createStudent(String name, String roll)
	{
		String key = name+" "+roll;
		if(!li.containsKey(key))
		{
			StudentType st = new StudentType(name, roll);
			li.put(key,st);
		}
		return li.get(key);
	}
	
}

class StudentInstance{
	
	private String cls;
	private StudentType st;
	
	StudentInstance(String cls, StudentType s)
	{
		this.cls = cls;
		this.st = s;
	}
	
	void display()
	{
		st.display(cls);
	}
}

public class Flyweight {
	public static void main(String [] args)
	{
		List<StudentInstance> li = new ArrayList<>();
		
		li.add(new StudentInstance("Telugu", StudentFactory.createStudent("Teju", "5344")));
		li.add(new StudentInstance("Hindi", StudentFactory.createStudent("Teju", "5344")));
		li.add(new StudentInstance("English", StudentFactory.createStudent("Ravi", "5374")));
		li.add(new StudentInstance("Maths", StudentFactory.createStudent("Teju", "5344")));
		
		for (StudentInstance stu : li) {
            stu.display();
        }
	}
}
