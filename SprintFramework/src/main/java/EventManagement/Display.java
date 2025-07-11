package EventManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Display {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int displayOptions()
	{
		 int choice = 0;
		
		System.out.println("1. Create new event");
		System.out.println("2. Delete exsisting event");
		System.out.println("3. View all events");
		System.out.println("4. Exit");
		
		System.out.println("Enter choice: ");
		
		try {
			choice = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Please Enter a Valid Input");
		}
		
		return choice;
 	}
	
	public static void main(String [] args)
	{
		
		ApplicationContext ap = new AnnotationConfigApplicationContext(EventConfig.class);
		
		EventManager em = ap.getBean(EventManager.class);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("          Welcome To Event Management      ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
//		
//		for (String name : ap.getBeanDefinitionNames()) {
//		    if (ap.isSingleton(name)) {
//		        Object bean = ap.getBean(name);
//		        System.out.println(name + " -> " + bean);
//		    }
//		}
//		
		
		int choice = 0;
		
		do {
			choice = displayOptions();
			
			if(choice==1)
			{
				Event e = ap.getBean(Event.class);
				
				em.getEvents().add(e);
			}else if(choice == 2)
			{
				ArrayList<Event> al = em.getEvents();
				
				int i = 0;
				for(Event e: al)
				{
					System.out.println(++i+" "+e);
				}
				
				System.out.println("Enter your choice: ");
				
				int ch = 0;
				
				try {
					ch = Integer.parseInt(br.readLine());
				} catch (NumberFormatException | IOException e1) {
					System.out.println("Enter a valid input!");
					continue;
				}
				
				Event e = al.get(i-1);
				System.out.println(e);
				try {
					e.destroy();
					em.deleteEvent(e);
				} catch (Exception e1) {
					System.out.println("Event not deleted");
				}
			}else if(choice == 3)
			{
				ArrayList<Event> al = em.getEvents();
				
				if(al.size()<=0)
				{
					System.out.println("No Events to Display.....");
					continue;
				}
				
				int i = 0;
				for(Event e: al)
				{
					System.out.println(++i+" "+e);
				}
				
			}else if(choice == 4)
			{
				System.out.println("Thank You!");
				break;
			}
		}while(true);
	}
}
