package JDBCTemplate;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	public static void main(String [] args)
	{
		ApplicationContext ap = new ClassPathXmlApplicationContext("JDBCTemplate/context.xml");
		
		DoctorDao d = ap.getBean(DoctorDao.class);
		
		Doctor d1 = new Doctor();
		d1.setFirst_name("Mani");
		d1.setLast_name("Deep");
		d1.setSpecialization("Eye Surgeon");
		
		System.out.println(d.insert(d1));
	}
}
