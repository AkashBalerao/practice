package WithoutXML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@ComponentScan(basePackages = "WithoutXML")
@Configuration
public class ConfigCls {
	
	@Bean
	@Scope("prototype")
	public String getName()
	{
		return "Abhi";
	}
	
	@Bean("Age")
	@Primary
	@Value("34")
	public int getAge()
	{
		return 24;
	}
	
	@Bean("age")
	@Value("65")
	public int getage()
	{
		return 24;
	}
	
	@Bean(name = {"student"})
	public Student getStudent()
	{
		Student s = new Student();
		return s;
	}
}
