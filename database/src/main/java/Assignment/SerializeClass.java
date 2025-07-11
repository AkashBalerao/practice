package Assignment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializeClass {

    public static Map<String, List<Product>> p = new HashMap<>();

//    public static void main(String[] args) throws Exception {
//
//    	Map<String, List<Product>> p = new HashMap<>();
//
//    	List<Product> groceries = new ArrayList<>();
//    	groceries.add(new Product("Basmati Rice (1kg)", 120, 5, 50));
//    	groceries.add(new Product("Wheat Flour (5kg)", 250, 5, 40));
//    	groceries.add(new Product("Toor Dal (1kg)", 140, 5, 60));
//    	groceries.add(new Product("Sunflower Oil (1L)", 160, 5, 30));
//    	groceries.add(new Product("Sugar (1kg)", 50, 5, 80));
//    	p.put("Groceries", groceries);
//
//    	List<Product> dairy = new ArrayList<>();
//    	dairy.add(new Product("Milk (1L)", 50, 0, 100));
//    	dairy.add(new Product("Curd (500g)", 35, 0, 80));
//    	dairy.add(new Product("Paneer (200g)", 80, 5, 60));
//    	dairy.add(new Product("Butter (100g)", 45, 5, 40));
//    	dairy.add(new Product("Cheese Slices (5 pcs)", 90, 12, 30));
//    	p.put("Dairy Products", dairy);
//
//    	List<Product> beverages = new ArrayList<>();
//    	beverages.add(new Product("Mineral Water (1L)", 20, 18, 200));
//    	beverages.add(new Product("Soft Drink (750ml)", 40, 28, 150));
//    	beverages.add(new Product("Orange Juice (1L)", 75, 12, 120));
//    	beverages.add(new Product("Tea (250g)", 90, 5, 90));
//    	beverages.add(new Product("Coffee (200g)", 130, 5, 70));
//    	p.put("Beverages", beverages);
//
//    	List<Product> personalCare = new ArrayList<>();
//    	personalCare.add(new Product("Toothpaste (100g)", 45, 18, 100));
//    	personalCare.add(new Product("Shampoo (180ml)", 120, 18, 80));
//    	personalCare.add(new Product("Soap Bar (125g)", 35, 18, 150));
//    	personalCare.add(new Product("Face Wash (100ml)", 110, 18, 70));
//    	personalCare.add(new Product("Hand Sanitizer (100ml)", 60, 18, 90));
//    	p.put("Personal Care", personalCare);
//
//    	List<Product> household = new ArrayList<>();
//    	household.add(new Product("Dish Wash Liquid (500ml)", 65, 18, 60));
//    	household.add(new Product("Detergent Powder (1kg)", 95, 18, 70));
//    	household.add(new Product("Floor Cleaner (1L)", 120, 18, 50));
//    	household.add(new Product("Garbage Bags (Small - 20pcs)", 60, 18, 80));
//    	household.add(new Product("Toilet Cleaner (500ml)", 85, 18, 65));
//    	p.put("Household Items", household);
//
//    	// Serialization
//    	File f1 = new File("Products");
//    	FileOutputStream fos = new FileOutputStream(f1);
//    	ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//    	oos.writeObject(p);
//
//    	oos.close();
//    	fos.close();
//
//    }
}
