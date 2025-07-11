package Week1Assignment;

import java.time.LocalDate;

public interface Items{
    void addItem(String name, int qunt);
    void addItem(String name, int qunt, LocalDate d);
    void addItem(String name, String status);
    void removeItem(String name, int qunt);
    void removeItem(String name);
    void searchItem(String name);
    void displayItems();
    void displayExpireFoods();
    void displayElectronicStatus();
    void updateStoreItemStatus(String s , String p);
}