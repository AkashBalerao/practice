package Assignment;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Bill implements Serializable{
	
	private Map<Product, Integer> Items = new HashMap<>();
	private double totalBill = 0;
	
	Bill(Map<Product, Integer> m, double totalBill)
	{
		this.Items = m;
		this.totalBill = totalBill;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public Map<Product, Integer> getItems() {
		return Items;
	}
	
	public void display()
	{
		
    	System.out.printf("%-30s %-10s %-10s %-10s %-15s%n", "Item Name", "Quantity", "Rate", "GST (%)", "Value");
    	System.out.println("------------------------------------------------------------------------------------------");

    	for (Product p : Items.keySet()) {
    	    int q = Items.get(p);
    	    double rate = p.getPrice();
    	    int gst = p.getGst();
    	    double value = p.priceAfterGst() * q;

    	    System.out.printf(
    	        "%-30s %-10d ₹%-9.2f %-10d ₹%-15.2f%n",
    	        p.getName(), q, rate, gst, value
    	    );
    	}


    	System.out.println("------------------------------------------------------------------------------------------");
    	System.out.printf("%-30s %-10s %-10s %-10s ₹%-15.2f%n", "Total Bill", "", "", "", totalBill);
	}
	
}
