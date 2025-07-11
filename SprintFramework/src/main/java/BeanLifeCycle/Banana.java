package BeanLifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Banana implements InitializingBean, DisposableBean{
	private double price;
	
	Banana(double p)
	{
		this.price = p;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying Banana");
	}

	@Override
	public String toString() {
		return "Banana [price=" + price + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Banana");
	}
	
	
}
