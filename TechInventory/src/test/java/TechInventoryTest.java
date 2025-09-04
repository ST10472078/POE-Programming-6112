/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.yourcompany.techinventory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class TechInventoryTest {
    
     @Test
    public void testDisplayInventoryReport() {
        // Create test inventory
        Product[] testInventory = new Product[2];
        testInventory[0] = new Product("T001", "TestItem", 10.00, 5);
        testInventory[1] = new Electronics("T002", "TestDevice", 50.00, 3, "TestBrand");
        
        // Test that the method runs without throwing exceptions
        try {
            TechInventory.displayInventoryReport(testInventory);
            assertTrue(true);
        } catch (Exception e) {
            fail("Method threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testDisplayInventoryReportWithNullElements() {
        // Create test inventory with null elements
        Product[] testInventory = new Product[3];
        testInventory[0] = new Product("T001", "TestItem", 10.00, 5);
        testInventory[1] = null;
        testInventory[2] = new Electronics("T002", "TestDevice", 50.00, 3, "TestBrand");
        
        try {
            TechInventory.displayInventoryReport(testInventory);
            assertTrue(true);
        } catch (Exception e) {
            fail("Method threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testSellProductValidSale() {
        Product[] testInventory = new Product[1];
        testInventory[0] = new Product("T001", "TestItem", 10.00, 5);
        
        TechInventory.sellProduct(testInventory, "T001", 2);
        
        // Use Integer.valueOf() to avoid autoboxing issues
        assertEquals(Integer.valueOf(3), Integer.valueOf(testInventory[0].getStock()));
    }

    @Test
    public void testSellProductInsufficientStock() {
        Product[] testInventory = new Product[1];
        testInventory[0] = new Product("T001", "TestItem", 10.00, 2);
        
        TechInventory.sellProduct(testInventory, "T001", 5);
        
        assertEquals(Integer.valueOf(2), Integer.valueOf(testInventory[0].getStock()));
    }

    @Test
    public void testSellProductNotFound() {
        Product[] testInventory = new Product[1];
        testInventory[0] = new Product("T001", "TestItem", 10.00, 5);
        
        TechInventory.sellProduct(testInventory, "NONEXISTENT", 1);
        
        assertEquals(Integer.valueOf(5), Integer.valueOf(testInventory[0].getStock()));
    }

    @Test
    public void testSellProductWithElectronics() {
        Product[] testInventory = new Product[1];
        testInventory[0] = new Electronics("E001", "Headphones", 100.00, 10, "Sony");
        
        TechInventory.sellProduct(testInventory, "E001", 3);
        
        assertEquals(Integer.valueOf(7), Integer.valueOf(testInventory[0].getStock()));
    }

    @Test
    public void testSellProductMultipleItems() {
        Product[] testInventory = new Product[2];
        testInventory[0] = new Product("P001", "Pen", 2.00, 20);
        testInventory[1] = new Product("P002", "Notebook", 5.00, 15);
        
        TechInventory.sellProduct(testInventory, "P002", 4);
        
        assertEquals(Integer.valueOf(20), Integer.valueOf(testInventory[0].getStock()));
        assertEquals(Integer.valueOf(11), Integer.valueOf(testInventory[1].getStock()));
    }

    @Test
    public void testSellProductZeroQuantity() {
        Product[] testInventory = new Product[1];
        testInventory[0] = new Product("T001", "TestItem", 10.00, 5);
        
        TechInventory.sellProduct(testInventory, "T001", 0);
        
        assertEquals(Integer.valueOf(5), Integer.valueOf(testInventory[0].getStock()));
    }
}
    
    
    
    
    

