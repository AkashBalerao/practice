package Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"Configurations","controller"})
@Import(value = {OrmConfig.class,SecurityConfig.class})
@EnableWebMvc
public class ServletConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/jsp/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver res = new  CommonsMultipartResolver();
		res.setMaxUploadSize(5*1024*1024);
		return res;
	}
	
	
	
	
//	@Bean
//    public LocalValidatorFactoryBean validator() {
//        return new LocalValidatorFactoryBean();
//    }
//
//    // Equivalent to <mvc:annotation-driven validator="validator"/>
//    @Override
//    public Validator getValidator() {
//        return validator();
//    }
}
