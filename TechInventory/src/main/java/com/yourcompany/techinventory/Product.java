/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourcompany.techinventory;

/**
 *
 * @author lab_services_student
 */
public class Product {
    
    private String productId;
    private String name;
    private double price;
    private int stock;

    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
    
   // Method to reduce stock
    public void sellItem(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
            System.out.println("Sold " + quantity + " of " + name);
        } else {
            System.out.println("Not enough stock! Only " + stock + " left.");
        }
    }

    // Method to display product info
    public void displayInfo() {
        System.out.printf("ID: %s | Name: %-10s | Price: $%-6.2f | Stock: %d%n",
                         productId, name, price, stock);
    }
} 
    

//Reference List

/*NetBeans IDE Documentation
Apache NetBeans. (2023). NetBeans IDE Documentation. [Online] Available at: 
https://netbeans.apache.org/kb/ 
[Accessed 3 September 2025]. */


