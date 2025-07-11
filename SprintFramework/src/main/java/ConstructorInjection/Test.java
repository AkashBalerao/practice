package ConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String [] args)
	{
		ApplicationContext ap = new ClassPathXmlApplicationContext("ConstructorInjection/personConfig.xml");
		Person p = (Person)ap.getBean("person1");
		System.out.println(p);
	}
}
