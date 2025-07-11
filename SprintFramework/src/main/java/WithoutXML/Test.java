package WithoutXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String [] args)
	{
		ApplicationContext ap = new AnnotationConfigApplicationContext(ConfigCls.class);
		Student s = ap.getBean("student", Student.class);
		s.display();
	}
}
