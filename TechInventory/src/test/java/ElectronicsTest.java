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
public class ElectronicsTest {
    
    @Test
    public void testElectronicsConstructor() {
        Electronics electronic = new Electronics("E001", "Headphones", 899.99, 15, "Sony");
        
        // Test inherited properties from Product class
        assertEquals("E001", electronic.getProductId());
        assertEquals("Headphones", electronic.getName());
        assertEquals(899.99, electronic.getPrice(), 0.001);
        assertEquals(15, electronic.getStock());
        
        // Test Electronics-specific property
        assertEquals("Sony", electronic.getBrand());
    }

    @Test
    public void testGetBrand() {
        Electronics electronic = new Electronics("E002", "Mouse", 115.75, 8, "Logitech");
        assertEquals("Logitech", electronic.getBrand());
    }

    @Test
    public void testDisplayInfo() {
        Electronics electronic = new Electronics("E003", "Keyboard", 250.00, 12, "Dell");
        
        // Test that displayInfo doesn't throw an exception
        try {
            electronic.displayInfo();
            assertTrue(true); // If we get here, the method worked
        } catch (Exception e) {
            fail("displayInfo() method threw an exception");
        }
    }

    @Test
    public void testInheritance() {
        Electronics electronic = new Electronics("E004", "Monitor", 1500.00, 5, "Samsung");
        
        // Verify that Electronics is actually a Product (inheritance)
        assertTrue(electronic instanceof Product);
    }

    @Test
    public void testSellItemInheritedMethod() {
        Electronics electronic = new Electronics("E005", "Tablet", 2000.00, 10, "Apple");
        
        // Test that sellItem method works (inherited from Product)
        electronic.sellItem(3);
        assertEquals(7, electronic.getStock());
    }

    @Test
    public void testEmptyBrand() {
        Electronics electronic = new Electronics("E006", "Charger", 50.00, 20, "");
        assertEquals("", electronic.getBrand());
    }

    @Test
    public void testNullBrand() {
        Electronics electronic = new Electronics("E007", "Cable", 15.00, 30, null);
        assertNull(electronic.getBrand());
    }
}
    
    
    
    

