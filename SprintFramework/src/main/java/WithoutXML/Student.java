package WithoutXML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Student {
	
	@Autowired
	private String name;
	
	@Autowired
	@Qualifier("age")
	private int age;
	
	@Value("35353")
	private int year;
	
	@Autowired
	private Teacher teacher;
	
	public void display()
	{
		System.out.println("Name: "+name + " Age: "+age+" Teacher: "+teacher+" Year: "+year);
	}
	
}
