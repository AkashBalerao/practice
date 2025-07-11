package AutoWiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String [] args)
	{
		ApplicationContext ap = new ClassPathXmlApplicationContext("AutoWiring/personConfig.xml");
		Person p = ap.getBean("person1", Person.class);
		System.out.println(p);
	}
}
