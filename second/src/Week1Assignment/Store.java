package Week1Assignment;

import java.time.LocalDate;

public class Store{
    Items inventory;

    void changeStore(Items I)
    {
        this.inventory = I;
    }

    void searchStoreItem(String name)
    {
        inventory.searchItem(name);
    }

    void addStoreItemFruit(String name, int qunt, LocalDate d)
    {
        inventory.addItem(name, qunt, d);
    }
    
    void updateStoreItemStatus(String name, String newStatus) {
    	inventory.updateStoreItemStatus(name, newStatus);
    }


    void addStoreItemElectronic(String name, String status)
    {
        inventory.addItem(name, status);
    }

    void removeStoreItemFruits(String name, int qunt)
    {
        inventory.removeItem(name, qunt);
    }

    void removeStoreItemElectornics(String name)
    {
        inventory.removeItem(name);
    }

    void displayStore()
    {
        inventory.displayItems();
    }

    void displayExpireFoods()
    {
        inventory.displayExpireFoods();
    }

    void displayElectronicStatus()
    {
        inventory.displayElectronicStatus();
    }
}
