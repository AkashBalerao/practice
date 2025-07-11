package com.springframework.SprintFramework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ap = new ClassPathXmlApplicationContext("com/springframework/SprintFramework/config.xml");
        Student s1 = (Student)ap.getBean("Student1");
        System.out.println(s1);
    }
}