package Week1Assignment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/*
 * 						Items(I)
 * 					/				\
 * 		  	Fruits					Electronics
 * 
 * 						Store(Items)
 * 
 * 						InventorySystem
 * 
 */

public class InventorySystem {
    static Scanner sc = new Scanner(System.in);

    public static void displayOptions(Store s) {
    	String storeType = s.inventory.getClass().getSimpleName();
    	int optionNumber = 1;

    	System.out.println(optionNumber++ + ". Add " + storeType + " Item");
    	System.out.println(optionNumber++ + ". Remove " + storeType + " Item");
    	System.out.println(optionNumber++ + ". Search " + storeType + " Item");
    	System.out.println(optionNumber++ + ". Display " + storeType + " Inventory");

    	if (s.inventory instanceof Fruits) {
    	    System.out.println(optionNumber++ + ". Display Expiring Fruits");
    	} else if (s.inventory instanceof Electronics) {
    	    System.out.println(optionNumber++ + ". Display Electronics Status");
    	    System.out.println(optionNumber++ + ". Change Electronic Status"); 
    	}

    	System.out.println(optionNumber++ + ". Change Store Type");
    	System.out.println(optionNumber + ". Return to Main Menu");

    	System.out.print("\u001B[35mEnter your choice: \u001B[0m");
    }
    
    public static void selectedOption(int storeChoice, Store store, Fruits f, Electronics e) {
        if (store.inventory instanceof Fruits) {
            handleFruitsOption(storeChoice, store, f, e);
        } else if (store.inventory instanceof Electronics) {
            handleElectronicsOption(storeChoice, store, f, e);
        } else {
            System.out.println("\u001B[31mInvalid store type! Please select a valid store.\u001B[0m");
        }
    }
    
    private static void handleFruitsOption(int storeChoice, Store store, Fruits f, Electronics e) {
        Scanner sc = new Scanner(System.in);

        switch (storeChoice) {
            case 1:
                System.out.print("Enter the fruit name: ");
                String fruitName = sc.nextLine().trim();

                int quantity = 0;
                boolean validQuantity = false;
                while (!validQuantity) {
                    System.out.print("Enter quantity: ");
                    String quantityInput = sc.nextLine().trim();
                    try {
                        quantity = Integer.parseInt(quantityInput);
                        if (quantity <= 0) {
                            System.out.println("Quantity must be a positive number.");
                        } else {
                            validQuantity = true;
                        }
                    } catch (NumberFormatException e3) {
                        System.out.println("Invalid input! Please enter a numeric value.");
                    }
                }

                System.out.print("Enter the expiry date (yyyy-MM-dd): ");
                LocalDate expiryDate = null;
                LocalDate today = LocalDate.now();

                while (expiryDate == null) {
                    try {
                        String dateInput = sc.nextLine().trim();
                        expiryDate = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);

                        if (expiryDate.isBefore(today)) {
                            System.out.print("Date cannot be in the past! Enter a future or today's date: ");
                            expiryDate = null;
                        }
                    } catch (DateTimeParseException e2) {
                        System.out.print("Invalid date format! Please use yyyy-MM-dd: ");
                    }
                }

                store.addStoreItemFruit(fruitName, quantity, expiryDate);
                System.out.println("Added " + quantity + " " + fruitName + "(s), expiring on " + expiryDate + ".");
                break;

            case 2:
                System.out.println("Enter the Fruit name: ");
                String removeFruitName = sc.next();
                System.out.println("Enter quantity: ");
                int fruitQuantity = sc.nextInt();
                store.removeStoreItemFruits(removeFruitName, fruitQuantity);
                break;

            case 3: 
                System.out.print("Enter the item name: ");
                String searchFruitName = sc.next();
                store.searchStoreItem(searchFruitName);
                break;

            case 4: 
                store.displayStore();
                break;

            case 5: 
                store.displayExpireFoods();
                break;

            case 6:
                store.changeStore(e);
                System.out.println("\u001B[32mSwitched to Electronics store.\u001B[0m");
                break;

            case 7: 
                System.out.println("\u001B[32mReturning to main menu...\u001B[0m");
                break;

            default:
                System.out.println("\u001B[31mInvalid choice! Please try again.\u001B[0m");
        }
    }
    
    private static void handleElectronicsOption(int storeChoice, Store store, Fruits f, Electronics e) {
        Scanner sc = new Scanner(System.in);

        switch (storeChoice) {
            case 1: 
                System.out.print("Enter the electronic name: ");
                String electronicName = sc.next();
                System.out.print("Enter the status (on/off): ");
                String status = sc.next();
                store.addStoreItemElectronic(electronicName, status);
                break;

            case 2: 
                System.out.println("Enter the Electronics name: ");
                String removeElectronicName = sc.next();
                store.removeStoreItemElectornics(removeElectronicName);
                break;

            case 3:
                System.out.print("Enter the item name: ");
                String searchElectronicName = sc.next();
                store.searchStoreItem(searchElectronicName);
                break;

            case 4: 
                store.displayStore();
                break;

            case 5: 
                store.displayElectronicStatus();
                break;

            case 6:
            	System.out.print("Enter the electronic item name: ");
                String electronicItemName = sc.next();
                System.out.print("Enter the new status (on/off): ");
                String newStatus = sc.next();
                store.updateStoreItemStatus(electronicItemName, newStatus);
                System.out.println("Changed status of " + electronicItemName + " to " + newStatus + ".");
                break;

            case 7: 
            	 store.changeStore(f);
                 System.out.println("\u001B[32mSwitched to Fruits store.\u001B[0m");
                 break;
                
            case 8: 
            	System.out.println("\u001B[32mReturning to main menu...\u001B[0m");
                break;

            default:
                System.out.println("\u001B[31mInvalid choice! Please try again.\u001B[0m");
        }
    }

    static{
        Fruits.allFruits[0] = new Fruits("Banana", 4, LocalDate.of(2025, 4, 23));
        Fruits.allFruits[1] = new Fruits("Apple", 5, LocalDate.of(2025, 5, 20));
        Fruits.allFruits[2] = new Fruits("Mango", 7, LocalDate.of(2025, 5, 2));

        Fruits.size=3;
        
        Electronics.allElectronics[0] = new Electronics("TV", "On");
        Electronics.allElectronics[1] = new Electronics("Fridge", "On");

        Electronics.size=2;
    }
    
    public static void main(String [] args)
    {
        System.out.println("Welcome to your Inventory System");

        int choice = 0;
        
        Store store = new Store();
        Fruits f = new Fruits();
        Electronics e = new Electronics();
        
        do{
            System.out.println("============ Main Menu ============");
            System.out.println("1. Fruits");
            System.out.println("2. Electronics");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if(choice==1)
            {
                store.changeStore(f);
            }else if(choice==2){
                store.changeStore(e);
            }else if(choice==3){
                break;
            }else{
                System.out.println("Invalid Input! Please try again");
                continue;
            }
            int storeChoice = 0;
            do {
                displayOptions(store);
                storeChoice = sc.nextInt();
                selectedOption(storeChoice, store, f, e);
            } while (storeChoice != 7);
        }while(true);
    }
}

















































//public static void selectedOption(int storeChoice, Store store, Fruits f, Electronics e)
//{
//  switch (storeChoice) {
//      case 1:
//      	if (store.Inventory instanceof Fruits) {
//      	    Scanner sc = new Scanner(System.in); // Assuming sc is your Scanner object
//      	    
//      	    System.out.print("Enter the fruit name: ");
//      	    String name = sc.nextLine().trim();
//      	    
//      	    int quantity = 0;
//      	    boolean validQuantity = false;
//      	    while (!validQuantity) {
//      	        System.out.print("Enter quantity: ");
//      	        String quantityInput = sc.nextLine().trim();
//      	        try {
//      	            quantity = Integer.parseInt(quantityInput);
//      	            if (quantity <= 0) {
//      	                System.out.println("Quantity must be a positive number.");
//      	            } else {
//      	                validQuantity = true;
//      	            }
//      	        } catch (NumberFormatException e3) {
//      	            System.out.println("Invalid input! Please enter a numeric value.");
//      	        }
//      	    }
//
//      	    System.out.print("Enter the expiry date (yyyy-MM-dd): ");
//      	    LocalDate date = null;
//      	    LocalDate today = LocalDate.now();
//
//      	    while (date == null) {
//      	        try {
//      	            String dateInput = sc.nextLine().trim(); 
//      	            date = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
//      	            
//      	            if (date.isBefore(today)) {
//      	                System.out.print("Date cannot be in the past! Enter a future or today's date: ");
//      	                date = null;
//      	            }
//      	        } catch (DateTimeParseException e2) {
//      	            System.out.print("Invalid date format! Please use yyyy-MM-dd: ");
//      	        }
//      	    }
//
//      	    System.out.println("Valid expiry date entered: " + date);
//
//      	    
//      	    store.addStoreItemFruit(name, quantity, date);
//      	    System.out.println("Added " + quantity + " " + name + "(s), expiring on " + date + ".");
//          } else {
//              System.out.print("Enter the electronic name: ");
//              String name = sc.next();
//              System.out.print("Enter the status (on/off): ");
//              String status = sc.next();
//              store.addStoreItemElectronic(name, status);
//          }
//          break;
//      case 2:
//          if(store.Inventory instanceof Fruits)
//          {
//              System.out.println("Enter the Fruit name :");
//              String name = sc.next();
//              System.out.println("Enter qunatity: ");
//              int qunt = sc.nextInt();
//              store.removeStoreItemFruits(name, qunt);
//          }else{
//              System.out.println("Enter the Electronics name :");
//              String name = sc.next();
//              store.removeStoreItemElectornics(name);
//          }
//          break;
//      case 3:
//          System.out.print("Enter the item name: ");
//          String nameSearch = sc.next();
//          store.searchStoreItem(nameSearch);
//          break;
//      case 4:
//          store.displayStore();
//          break;
//      case 5:
//          if (store.Inventory instanceof Fruits) {
//              store.displayExpireFoods();
//          } else if(store.Inventory instanceof Electronics) {
//              store.displayElectronicStatus();
//          }
//          break;
//      case 6:
//          if (store.Inventory instanceof Fruits) {
//              store.changeStore(e);
//              System.out.println("\u001B[32mSwitched to Electronics store.\u001B[0m");
//          } else {
//              store.changeStore(f);
//              System.out.println("\u001B[32mSwitched to Fruits store.\u001B[0m");
//          }
//          break;
//      case 7:
//          System.out.println("\u001B[32mReturning to main menu...\u001B[0m");
//          break;
//      default:
//          System.out.println("\u001B[31mInvalid choice! Please try again.\u001B[0m");
//  }
//}

