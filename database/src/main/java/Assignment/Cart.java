package Assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.*;

class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }
}

public class Cart {
    private Map<Product, Integer> cartItems = new HashMap<>();
    private double totalBill = 0;
    private Scanner sc = new Scanner(System.in);

    public void addToCart(Product p, int q) {
    	
    	//custom notEnoughItemAvaliable exception
    	try {
	        if(cartItems.containsKey(p) && q<=p.getQuantity())
	        {
	        	cartItems.put(p, cartItems.get(p)+q);
	        }else if(q<=p.getQuantity()){
	        	cartItems.put(p, q);
	        }else {
	        	throw new NotEnoughItemsAvaliable("Your Input Exceeded the current stock: "+p.getQuantity());
	        }
	        p.setQuantity(p.getQuantity()-q);
	        totalBill += p.priceAfterGst() * q;    
	        System.out.println(p.getName() + " added to cart. Quantity: " + q);
    	}catch(NotEnoughItemsAvaliable e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
    
    public void viewCart() throws IOException {
    	
    	//custom cartisEmpty exception
    	try {
    		if (cartItems.isEmpty()) {
    			throw new CartIsEmptyException("Cart is empty! Please add items.");
    		}
    	}catch(CartIsEmptyException e)
    	{
    		System.out.println(e.getMessage());
    		return;
    	}
    	
    	System.out.println("\n--------------------Cart Items---------------------\n");
    	System.out.printf("%-30s %-10s %-10s%n", "Item Name", "Quantity", "Rate");
    	System.out.println("-----------------------------------------------------");
    	for(Product p : cartItems.keySet()){
    	    int q = cartItems.get(p);
    	    double rate = p.getPrice();
    	    int gst = p.getGst();

    	    System.out.printf("%-30s %-10d ₹%-9.2f%n", p.getName(), q, rate);
    	}

    	System.out.println("-----------------------------------------------------");

        
        do {
        	System.out.println("\n1. Remove an item \n2. Continue shopping \n3. Checkout");
        	int choice = 0;
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	try {
        		choice = Integer.parseInt(br.readLine());
        		if(choice<1 || choice>3)
        		{
        			throw new InvalidItemNumber("Invalid choice Number, Please Try Again!");
        		}
        	}catch(InvalidItemNumber e)
        	{
        		System.out.println(e.getMessage());
        		continue;
        	}catch(NumberFormatException s)
        	{
        		System.out.println("Invalid choice Number, Please Try Again!");
        		continue;
        	}
        	
        	if(choice==1)
        	{
        		removeItem();
        		continue;
        	}else if(choice==2)
        	{
        		return;
        	}else if(choice==3)
        	{
        		checkout();
        		break;
        	}
        	
        }while(true);
    }

    public void removeItem() throws IOException {
    	System.out.println("\n--------------------Cart Items---------------------\n");
    	System.out.printf("%-30s %-10s %-10s%n", "Item Name", "Quantity", "Rate");
    	System.out.println("-----------------------------------------------------");
    	int i=1;
    	for(Product p : cartItems.keySet()){
    	    int q = cartItems.get(p);
    	    double rate = p.getPrice();
    	    int gst = p.getGst();

    	    System.out.printf("%d %-30s %-10d ₹%-9.2f%n", i, p.getName(), q, rate);
    	    i++;
    	}

    	do {
	        System.out.println("Enter Item Number to remove(0 to exit):");
	        int itemNumber = 0;
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        try {
	    		itemNumber = Integer.parseInt(br.readLine());
	    		if(itemNumber>cartItems.size() || itemNumber<0)
	    		{
	    			throw new InvalidItemNumber("Invalid Item Number, Please Try Again!");
	    		}
	    	}catch(InvalidItemNumber e)
	    	{
	    		System.out.println(e.getMessage());
	    		continue;
	    	}catch(NumberFormatException s)
	    	{
	    		System.out.println("Invalid Item Number, Please Try Again!");
	    		continue;
	    	}
	
	        
            int index = itemNumber - 1;
            if(index==-1)
            {
            	break;
            }
            Product p = null;
            for(Product l: cartItems.keySet())
            {
            	if(index==0)
            	{
            		p = l;
            		break;
            	}
            	index--;
            }

            totalBill -= p.getPrice() * cartItems.get(p);
            
            p.setQuantity(cartItems.get(p)+p.getQuantity());
            cartItems.remove(p);
//            quantity.remove(index);
            System.out.println(p.getName() + " removed from cart.");
    	}while(true);
    }
    
    public Bill createBill()
    {
    	return new Bill(cartItems, totalBill);
    }

    public void checkout() {
    	
    	//custom cartisEmpty exception
    	try {
    		if (cartItems.isEmpty()) {
    			throw new CartIsEmptyException("Cart is empty! Please add items before checkout.");
    		}
    	}catch(CartIsEmptyException e)
    	{
    		System.out.println(e.getMessage());
    		return;
    	}
        
        Bill b = createBill();
        
        b.display();
        
    	try {
			storeBill(b);
			cartItems.clear();
			totalBill = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	System.out.println("\nThank You For Shopping! Visit Again!\n");
    }
    
    
    public void storeBill(Bill b) throws Exception
    {
    	File file = new File("Bills.ser");
    	boolean append = file.exists();

    	ObjectOutputStream oos;
    	if (append) {
    	    oos = new AppendableObjectOutputStream(new FileOutputStream(file, true));
    	} else {
    	    oos = new ObjectOutputStream(new FileOutputStream(file));
    	}

    	oos.writeObject(b);
    	oos.close();

    }
    
}
