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
public class ProductTest {
    
     @Test
    public void testProductConstructor() {
        Product product = new Product("P001", "Test Product", 10.99, 50);
        
        assertEquals("P001", product.getProductId());
        assertEquals("Test Product", product.getName());
        assertEquals(10.99, product.getPrice(), 0.001);
        assertEquals(50, product.getStock());
    }

    @Test
    public void testSellItemValidQuantity() {
        Product product = new Product("P001", "Test Product", 10.99, 50);
        
        product.sellItem(10);
        
        assertEquals(40, product.getStock());
    }

    @Test
    public void testSellItemInsufficientStock() {
        Product product = new Product("P001", "Test Product", 10.99, 5);
        
        product.sellItem(10);
        
        assertEquals(5, product.getStock());
    }

    @Test
    public void testSellItemExactStock() {
        Product product = new Product("P001", "Test Product", 10.99, 10);
        
        product.sellItem(10);
        
        assertEquals(0, product.getStock());
    }

    @Test
    public void testSellItemZeroQuantity() {
        Product product = new Product("P001", "Test Product", 10.99, 50);
        
        product.sellItem(0);
        
        assertEquals(50, product.getStock());
    }

    @Test
    public void testSellItemMultipleTimes() {
        Product product = new Product("P001", "Test Product", 10.99, 100);
        
        product.sellItem(20);
        product.sellItem(30);
        product.sellItem(10);
        
        assertEquals(40, product.getStock());
    }

    @Test
    public void testGetters() {
        Product product = new Product("P123", "Sample Item", 25.50, 75);
        
        assertEquals("P123", product.getProductId());
        assertEquals("Sample Item", product.getName());
        assertEquals(25.50, product.getPrice(), 0.001);
        assertEquals(75, product.getStock());
    }

    @Test
    public void testDisplayInfo() {
        Product product = new Product("P999", "Display Test", 99.99, 25);
        
        try {
            product.displayInfo();
            assertTrue(true);
        } catch (Exception e) {
            fail("displayInfo() method threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testNegativeStockPrevention() {
        Product product = new Product("P001", "Test Product", 10.99, 10);
        
        product.sellItem(15);
        
        // CORRECTED LINE: JUnit 4 syntax - message first, then condition
        assertTrue(product.getStock() >= 0);
        
        // Additional check to be sure
        assertEquals(10, product.getStock());
    }
    
    @Test
    public void testSellItemNegativeQuantity() {
        Product product = new Product("P001", "Test Product", 10.99, 50);
        
        product.sellItem(-5); // Try to sell negative quantity
        
        // Stock should remain unchanged
        assertEquals(50, product.getStock());
    }
}
    
  