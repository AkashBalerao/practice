package StandAloneCollections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String [] args)
	{
		ApplicationContext ap = new ClassPathXmlApplicationContext("StandAloneCollections/studentConfig.xml");
		StudentDB s = ap.getBean("studentdb1",StudentDB.class);
		System.out.println(s);
	}
}
