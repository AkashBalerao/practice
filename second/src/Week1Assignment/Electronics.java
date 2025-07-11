package Week1Assignment;

import java.time.LocalDate;

public class Electronics implements Items{
    static Electronics allElectronics[] = new Electronics[100];
    public  static int size = 0;
    private String name;
    private String status;

    Electronics(){};

    Electronics(String name, String status)
    {
        this.name = name;
        this.status = status;
    }
    
    public void updateStoreItemStatus(String name, String newStatus) {
        int indexOf = searchForItem(name);
        if (indexOf != -1) {
            allElectronics[indexOf].status = newStatus;
            System.out.println("Updated status of " + name + " to " + newStatus);
        } else {
            System.out.println("Item not found: " + name);
        }
    }

    
    public void addItem(String name, int qunt){};

    public void addItem(String name, int qunt, LocalDate d){};

    public void addItem(String name, String status)
    {
        int indexOf = searchForItem(name);
        if (indexOf != -1) {
            System.out.println("Item already present: " + name );
        } else {
            if (size < 100) {
                allElectronics[size++] = new Electronics(name, status);
                System.out.println("Item added: " + name + " (" + status + ")");
            } else {
                System.out.println("Inventory full, cannot add more items.");
            }
        }
    }

    public void removeItem(String name)
    {
        int indexOf = searchForItem(name);
        if(indexOf!=-1)
        {
            for(int i=indexOf; i<size; i++)
            {
                allElectronics[i] = allElectronics[i+1];
            }
            size--;
            System.out.println("Item removed: "+ name);
        }else{
            System.out.println("Items not avaliable to remove");
        }
    }

    public void removeItem(String name, int qunt){};


    int searchForItem(String name)
    {
        for(int i=0; i<size; i++)
        {
            if(name.equalsIgnoreCase(allElectronics[i].name))
            {
                return i;
            }
        }
        return -1;
    }

    public void searchItem(String name)
    {
        int indexOf = searchForItem(name);
        if(indexOf != -1)
        {
            System.out.println("Found: " + name + " | Status: " + allElectronics[indexOf].status);
        }else{
            System.out.println(name+": Not found");
        }
    }

    public void displayItems()
    {
        if(size == 0)
        {
            System.out.println("No electronics in inventory.");
            return;
        }
        System.out.println("\n========== Electronics Inventory ==========");

        System.out.printf("\t%-20s\n", "Name");
        for (int i = 0; i < size; i++) {
            System.out.printf("\t%-20s\n", allElectronics[i].name);
        }
        System.out.println("=====================================");
    }

    public void displayExpireFoods(){};

    public void displayElectronicStatus()
    {
        if (size == 0) {
            System.out.println("No electronics in inventory.");
            return;
        }
        System.out.println("\n========== Electronics Inventory ==========");
        System.out.printf("%-20s %-10s\u001B[0m\n", "Name", "Status");
        for (int i = 0; i < size; i++) {
            System.out.printf("%-20s %-10s\n", allElectronics[i].name, allElectronics[i].status);
        }
        System.out.println("==========================================");
    }
}