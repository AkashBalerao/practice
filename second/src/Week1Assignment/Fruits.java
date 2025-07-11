package Week1Assignment;

import java.time.LocalDate;
import java.util.Arrays;

public class Fruits implements Items{
    public static Fruits allFruits[]= new Fruits[100];
    public static int size = 0;
    private String name;
    private int quantity;
    private LocalDate date;

    Fruits(){};

    Fruits(String name, int qunt, LocalDate d)
    {
        this.name = name;
        this.quantity = qunt;
        this.date = d;
    }

    public void addItem(String name, int qunt){};
    public void addItem(String name, String s){};

    public void addItem(String name, int qunt, LocalDate d)
    {
        int indexOf = searchForItem(name);
        if(indexOf != -1)
        {
            allFruits[indexOf].quantity += qunt;
            System.out.println("Updated quantity of "+name+" to "+allFruits[indexOf].quantity);
        }else{
            if(size < 100)
            {
                Fruits e = new Fruits(name, qunt, d);
                allFruits[size] = e;
                size++;
                System.out.println("Item added " + name + " ( " + qunt + " )");
            }else{
                System.out.println("Inventory full, cannot add more items.");
            }
        }
    }

    public void removeItem(String name){};

    public void removeItem(String name, int qunty) {
        int indexOf = searchForItem(name);
        
        if (indexOf == -1) {
            System.out.println("Item not found in inventory.");
            return;
        }

        if (qunty <= 0) {
            System.out.println("Invalid quantity. Please enter a positive number.");
            return;
        }

        if (qunty < allFruits[indexOf].quantity) {
            allFruits[indexOf].quantity -= qunty;
            System.out.println("Removed " + qunty + " of " + name + ". Remaining: " + allFruits[indexOf].quantity);
        } else if (qunty == allFruits[indexOf].quantity) {
            for (int i = indexOf; i < size - 1; i++) {
                allFruits[i] = allFruits[i + 1];
            }
            allFruits[size - 1] = null;
            size--;
            System.out.println(name + " has been removed from inventory.");
        } else {
            System.out.println("Not enough items available to remove. Available: " + allFruits[indexOf].quantity);
        }
    }

    int searchForItem(String name)
    {
        for(int i=0; i<size; i++)
        {
            if(name.equalsIgnoreCase(allFruits[i].name))
            {
                return i;
            }
        }
        return -1;
    }

    public void searchItem(String name)
    {
        int indexOf = searchForItem(name);
        if(indexOf !=-1)
        {
            System.out.println("Found: " + name + " | Quantity: " + allFruits[indexOf].quantity + " | Expiry: " + allFruits[indexOf].date);
        }else{
            System.out.println("Not found: " + name );
        }
    }

    public void displayItems()
    {
        if(size == 0)
        {
            System.out.println("No fruits in inventory.");
            return;
        }
        System.out.println("\n========== Fruits Inventory ==========");

        System.out.printf("%-20s %-10s %-12s\n", "Name", "Quantity", "Expiry Date");
        for (int i = 0; i < size; i++) {
            System.out.printf("%-20s %-10d %-12s\n", allFruits[i].name, allFruits[i].quantity, allFruits[i].date);
        }
        System.out.println("=====================================");
    }

    public void displayExpireFoods()
    {
        if(size == 0)
        {
            System.out.println("No fruits in inventory");
            return;
        }
        Fruits expires[] = Arrays.copyOf(allFruits, size);
        Arrays.sort(expires, 0, size, (a, b) -> a.date.compareTo(b.date));
        
        System.out.println("\n========== Fruits Inventory ==========");

        System.out.printf("%-20s %-10s %-12s\n", "Name", "Quantity", "Expiry Date");

        for (int i = 0; i < size; i++) {
            System.out.printf("%-20s %-10d %-12s\n", expires[i].name, expires[i].quantity, expires[i].date);
        }
        System.out.println("====================================");
    }

    public void displayElectronicStatus(){}

	@Override
	public void updateStoreItemStatus(String s, String p) {
		// TODO Auto-generated method stub
		
	};
}