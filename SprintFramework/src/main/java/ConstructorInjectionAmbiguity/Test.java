package ConstructorInjectionAmbiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("ConstructorInjectionAmbiguity/addConfig.xml");
		Addition ad = (Addition) ap.getBean("add1");
		ad.sum();
	}
}
