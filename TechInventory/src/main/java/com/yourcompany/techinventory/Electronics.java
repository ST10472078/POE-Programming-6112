/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourcompany.techinventory;

/**
 *
 * @author lab_services_student
 */
public class Electronics extends Product{
    private String brand;
    
    // Constructor calling the parent constructor using super()
    public Electronics(String productId, String name, double price, int stock, String brand) {
        super(productId, name, price, stock); // Calls Product constructor
        this.brand = brand;
    }
    
    public String getBrand() { 
        return brand; 
    }
    
    //Overriding the display method from the parent class
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + brand);
    }
    
}

//Reference List

/*NetBeans IDE Documentation
Apache NetBeans. (2023). NetBeans IDE Documentation. [Online] Available at: 
https://netbeans.apache.org/kb/ 
[Accessed 3 September 2025]. */