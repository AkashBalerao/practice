package Assignment;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String name;
	private double price;
	private int gst;
	private int quantity;
	
	Product(String name, int price, int gst, int quantity)
	{
		this.name = name;
		this.price = price;
		this.gst = gst;
		this.quantity = quantity;
	}
	
	String getName()
	{
		return this.name;
	}
	
	double getPrice()
	{
		return this.price;
	}
	
	double priceAfterGst()
	{
		return price+price*((double)gst/100);
	}
	
	int getGst()
	{
		return this.gst;
	}
	
	int getQuantity()
	{
		return this.quantity;
	}
	
	void setQuantity(int s)
	{
		this.quantity = s;
	}
	
}
