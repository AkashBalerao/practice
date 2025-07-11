package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class ProductMenu {
	
    private static Map<String, List<Product>> category = new HashMap<>();
        
    static {
    	File f = new File("Products");
    	FileInputStream fis = null;
    	ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	try {
			category = (Map<String, List<Product>>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
    }

    public void displayMenu(String c, Cart cart) {
        List<Product> menu = category.get(c);

        if (menu == null || menu.isEmpty()) {
            System.out.println("No items available in this category.");
            return;
        }

        do {
        	Scanner sc = new Scanner(System.in);
        	System.out.println("\n========================================================");
        	System.out.printf("                     Category: %s\n", c);
        	System.out.println("========================================================");
        	System.out.printf("%-4s %-25s %-10s %-8s %-10s\n", "No.", "Product", "Price", "GST%", "In Stock");
        	System.out.println("--------------------------------------------------------");

        	for (int i = 0; i < menu.size(); i++) {
        	    Product p = menu.get(i);
        	    System.out.printf("%-4d %-25s ₹%-9.2f %-8d %-10d\n",
        	        i + 1,
        	        p.getName(),
        	        p.getPrice(),
        	        p.getGst(),
        	        p.getQuantity()
        	    );
        	}

        	System.out.println("--------------------------------------------------------");
        	System.out.print("Enter item number to add to cart (0 to cancel): ");
        	int choice = sc.nextInt();

        	if (choice < 1 || choice > menu.size()) {
        	    System.out.println("Cancelled or Invalid choice.");
        	    return;
        	}

	
	        Product selectedProduct = menu.get(choice - 1);
	
	        System.out.print("Enter quantity: ");
	        int quantity = sc.nextInt();
	
	        cart.addToCart(selectedProduct, quantity);
        }while(true);
    }
}