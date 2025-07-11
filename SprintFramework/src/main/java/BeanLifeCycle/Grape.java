package BeanLifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Grape {
	private int price;
	
	Grape(int p)
	{
		this.price = p;
	}
	
	@PostConstruct
	public void start()
	{
		System.out.println("Starting grape");
	}
	
	@Override
	public String toString() {
		return "Grape [price=" + price + "]";
	}

	@PreDestroy
	public void end()
	{
		System.out.println("Destroying grape");
	}
}
