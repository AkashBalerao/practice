package EventManagement;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

enum Events{
	SOCIAL, CORPORATE, CULTURAL, SPORTS, COMMUNITY;
}

@Component
@Scope("prototype")
public class Event implements InitializingBean, DisposableBean { 
	
	private Events eventType;
	private String Name;
	
	private int capacity;
	
	public int getCapacity() {
		return capacity;
	}
	
	@Autowired
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public Events getEventType() {
		return eventType;
	}
	
	@Autowired
	public void setEventType(Events eventType) {
		this.eventType = eventType;
	}
	public String getName() {
		return Name;
	}
	
	@Autowired
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return String.format(
		        "Event Details:\n" +
		        "---------------------------\n" +
		        "Name       : %s\n" +
		        "Type       : %s\n" +
		        "Capacity   : %d\n",
		        Name, eventType, capacity
		    );
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Event Created.....");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Event ended.......");
	}
}
