/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.yourcompany.techinventory;
import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */
public class TechInventory {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        
        // Create an array of Products (the base class type)
        Product[] inventory = new Product[5];
        
        // Adding products to the array (including an Electronics object)
        inventory[0] = new Product("P101", "Notebook", 36.50, 100);
        inventory[1] = new Electronics("E201", "Headphones", 899.99, 15, "Sony");
        inventory[2] = new Product("P102", "Pen", 3.20, 200);
        inventory[3] = new Electronics("E202", "Mouse", 115.75, 8, "Logitech");
        inventory[4] = new Product("P103", "Eraser", 10.50, 150);

        boolean running = true;
        
        while (running) {
            System.out.println("\n--- Inventory System ---");
            System.out.println("1. Display All Products");
            System.out.println("2. Sell a Product");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    displayInventoryReport(inventory);
                    break;
                    
                case 2:
                    System.out.print("Enter product ID to sell: ");
                    String id = scanner.next();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    sellProduct(inventory, id, qty);
                    break;
                    
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    // Method to display report using a loop
    public static void displayInventoryReport(Product[] inventory) {
        System.out.println("\n=== INVENTORY REPORT ===");
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                inventory[i].displayInfo();
            }
        }
        System.out.println("========================");
    }

    // Method to find and sell a product using a loop
    public static void sellProduct(Product[] inventory, String id, int qty) {
        boolean found = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].getProductId().equals(id)) {
                inventory[i].sellItem(qty);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product ID not found!");
        }
    }
}   
    

//Reference List

/*NetBeans IDE Documentation
Apache NetBeans. (2023). NetBeans IDE Documentation. [Online] Available at: 
https://netbeans.apache.org/kb/ 
[Accessed 3 September 2025]. */

/*ArrayList Class Documentation
Oracle. (2023). Class ArrayList<E>. Java Platform SE 17. [Online] Available at:
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html 
[Accessed 2 September 2025]. */