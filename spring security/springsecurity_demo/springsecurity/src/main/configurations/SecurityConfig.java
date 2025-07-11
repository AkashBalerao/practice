package Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password("{noop}user").roles("user")
		.and()
		.withUser("admin").password("{noop}admin").roles("user","admin");
	}
	
	 @Override
	protected void configure(HttpSecurity http) throws Exception {

		 http.authorizeRequests()
		 .antMatchers("/").permitAll()
		 .antMatchers("/user").hasAnyRole("user","admin")
		 .antMatchers("/admin").hasRole("admin")
		 .and().formLogin()
		 .and().exceptionHandling().accessDeniedPage("/accessdenied");
	}
	 
}
