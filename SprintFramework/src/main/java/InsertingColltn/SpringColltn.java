package InsertingColltn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringColltn {
	
	public static void main(String [] args)
	{
		ApplicationContext ap = new ClassPathXmlApplicationContext("InsertingColltn/config2.xml");
		Emp e = (Emp) ap.getBean("emp1");
		System.out.println(e);
	}

}
