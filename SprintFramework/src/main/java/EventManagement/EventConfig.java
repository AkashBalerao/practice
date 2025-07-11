package EventManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"EventManagement"})
public class EventConfig {
	
	
	@Bean
	public ArrayList<Event> getEvents()
	{
		ArrayList<Event> al = new ArrayList<>();
		return al;
	}
	
	@Bean
	@Scope("prototype")
	public int getCapacity()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int capacity = 0;
		
		try {
			System.out.println("Enter event capacity: ");
			capacity = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Enter a valid Input");
		}
		
		return capacity;
	}
	
	@Bean
	@Scope("prototype")
	public String getName()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = null;
		
		try {
			System.out.println("Enter event Name: ");
			name = br.readLine();
		} catch (NumberFormatException | IOException e) {
			System.out.println("Enter a valid Input");
		}
		
		return name;
	}
	
	@Bean
	@Scope("prototype")
	public Events getEventType()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Select Event Type: ");
		System.out.println("1. Social");
		System.out.println("2. Corporate");
		System.out.println("3. Cultural");
		System.out.println("4. Sports");
		System.out.println("5. Community");
		
		int choice = 0;
		try {
			choice = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Please Enter a Valid Input");
		}
		
		if(choice == 1)
		{
			return Events.SOCIAL;
		}else if(choice == 2)
		{
			return Events.CORPORATE;
		}else if(choice == 3)
		{
			return Events.CULTURAL;
		}else if(choice == 4)
		{
			return Events.SPORTS;
		}else if(choice == 5)
		{
			return Events.COMMUNITY;
		}
		
		return null;
	}
}
