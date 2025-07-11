package BeanLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("BeanLifeCycle/fruitConfig.xml");
//		ap.registerShutdownHook();
//		Apple a =(Apple) ap.getBean("apple1");
//		System.out.println(a);
		
//		Banana b = (Banana) ap.getBean("banana1");
//		System.out.println(b);
		
		Grape g = (Grape) ap.getBean("grape1");
		System.out.println(g);
		((AbstractApplicationContext) ap).close();
	}
}
