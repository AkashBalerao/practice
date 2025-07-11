package Assignment;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class Display {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static List<User> users = new ArrayList<>();
	private Cart cart = new Cart();
	private static ProductMenu menu = new ProductMenu();
	
	public void register() throws IOException {
	    System.out.println("Create Usename:");
	    String name = br.readLine();
	    System.out.println("Create password:");
	    String password = br.readLine();
	    User user = new User(name, password);
	    addUserToFile(user);
	    System.out.println("Registered successfully!");
	}
	
	public void addUserToFile(User u) throws IOException
	{
		File f = new File("Users");
		boolean append = f.exists();
		
		ObjectOutputStream oos;
		if(append)
		{
			oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
		}else {
			oos = new ObjectOutputStream(new FileOutputStream(f));
		}
	    oos.writeObject(u);
	    oos.close();
	}
	
	public User login() throws IOException, ClassNotFoundException {
		
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("Users"));
			User u = null;
			while((u = (User)ois.readObject())!=null)
			{
				users.add(u);
			}
		}catch(IOException e)
		{
		}
		
	    System.out.println("Enter name:");
	    String name = br.readLine();
	    System.out.println("Enter password:");
	    String password = br.readLine();
	    for (User user : users) {
	        if (user.getName().equals(name) && user.validatePassword(password)) {
	            System.out.println("Login successful!");
	            return user;
	        }
	    }
	    System.out.println("Invalid credentials.");
	    return null;
	}
	
	public void menu() throws IOException {
	    while (true) {
	    	System.out.println("1.Buy Items \n2.View Cart \n3.Checkout \n4.Home");
	        int choice = 0;
	        
	        //custom invalidItemNumber exception
	        try {
	        	choice = Integer.parseInt(br.readLine());
        		if(choice>4 || choice<1)
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
	        if (choice==1) {
	        	int category = 0;
	            do {
	            	System.out.println("1. Groceries\n2. Dairy Products\n3. Beverages\n4. Personal Care\n5. Household Items\n6. Back");
	            	
	            	try {
	            		category = Integer.parseInt(br.readLine());
	            		if(category>6 || category<1)
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
	            	
	            	ArrayList<String> cats = new ArrayList<>();
	            	cats.add("Groceries");
	            	cats.add("Dairy Products");
	            	cats.add("Beverages");
	            	cats.add("Personal Care");
	            	cats.add("Household Items");
	            	if(category==6)
	            	{
	            		break;
	            	}
	            	menu.displayMenu(cats.get(category-1), cart);
	            }while(true);
	        } else if (choice==2) {
	            cart.viewCart();
	        } else if (choice==3) {
	            cart.checkout();
	        }else if(choice==4)
	        {
	        	return;
	        }
	    }
	}
	
	public void startOrder() throws NumberFormatException, IOException, ClassNotFoundException {
		while (true) {
	        System.out.println("1. New Customer \n2. Login \n3. Profits \n4. Exit");
	        int choice = 0;
	        try {
	        	choice = Integer.parseInt(br.readLine());
        		if(choice>4 || choice<1)
        		{
        			throw new InvalidItemNumber("Invalid choice, Please Try Again!");
        		}
        	}catch(InvalidItemNumber e)
        	{
        		System.out.println(e.getMessage());
        		continue;
        	}catch(NumberFormatException s)
        	{
        		System.out.println("Invalid choice, Please Try Again!");
        		continue;
        	}
	        switch (choice) {
	            case 1:
	                register();
	                break;
	            case 2:
	                User user = login();
	                if (user != null) menu();
	                break;
	            case 3:
	            	printTotalProfit();
	            	break;
	            case 4:
	                return;
	            default:
	                System.out.println("Invalid input");
	        }
	    }
	}
	
    private void printTotalProfit() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Bills.ser"));

		double profit = 0;
		Bill bill = null;
		try
		{
			while((bill = (Bill)ois.readObject())!=null)
			{
				bill.display();
				profit += bill.getTotalBill();
				System.out.println();
			}
		}
		catch(EOFException w)
		{
			System.out.printf("Total Profits for Today: %.2f\n",profit);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException {
        Display display  = new Display();
        display.startOrder();
    }
}