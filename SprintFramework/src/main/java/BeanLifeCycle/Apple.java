package BeanLifeCycle;

public class Apple {
	
	private double price;
	
	Apple(double p)
	{
		this.price = p;
	}

	@Override
	public String toString() {
		return "Apple [price=" + price + "]";
	}
	
	public void init()
	{
		System.out.println("Initalizing apple");
	}
	
	public void destroy()
	{
		System.out.println("Destroying apple");
	}
	
}
