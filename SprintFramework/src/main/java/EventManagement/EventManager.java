package EventManagement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("singleton")
public class EventManager {
	
	@Autowired
	private ArrayList<Event> events;
	
	public ArrayList<Event> getEvents()
	{
		return events;
	}
	
	public void deleteEvent(Event e)
	{
		if(events.remove(e))
		{
			System.out.println("Event Deleted.....");
		}else {
			System.out.println("Couldn't complete the process......");
		}
	}

}
