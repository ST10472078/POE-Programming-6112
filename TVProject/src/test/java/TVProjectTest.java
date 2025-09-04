/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.yourcompany.tvproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.AfterEach;
/**
 *
 * @author lab_services_student
 */
public class TVProjectTest {
    
     @BeforeEach
    public void setUp() {
        // Clear the seriesList before each test
        TVProject.clearSeriesListForTesting();
        
        // Add test data
        TVProject.addSeriesForTesting(new SeriesModel("101", "Extreme Sports", "12", "10"));
        TVProject.addSeriesForTesting(new SeriesModel("102", "Jungle Hunters", "10", "15"));
        TVProject.addSeriesForTesting(new SeriesModel("103", "Home Cooking", "8", "20"));
    }
    
    @AfterEach
    public void tearDown() {
        TVProject.clearSeriesListForTesting();
    }
    
    @Test
    public void TestSearchSeries() {
        // Test that correct series data is returned
        SeriesModel result = TVProject.searchSeriesById("101");
        
        assertNotNull(result);
        assertEquals("101", result.seriesId);
        assertEquals("Extreme Sports", result.seriesName);
        assertEquals("12", result.seriesAge);
        assertEquals("10", result.seriesNumberOfEpisodes);
    }
    
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        // Test that no series is found for incorrect ID
        SeriesModel result = TVProject.searchSeriesById("999");
        
        assertNull(result);
    }
    
    @Test
    public void TestUpdateSeries() {
        // Test that series is successfully updated
        boolean updateResult = TVProject.updateSeriesForTesting("101", "Extreme Sports 2025", "10", "12");
        
        assertTrue(updateResult);
        
        // Verify the update
        SeriesModel updatedSeries = TVProject.searchSeriesById("101");
        assertNotNull(updatedSeries);
        assertEquals("Extreme Sports 2025", updatedSeries.seriesName);
        assertEquals("10", updatedSeries.seriesAge);
        assertEquals("12", updatedSeries.seriesNumberOfEpisodes);
    }
    
    @Test
    public void TestUpdateSeries_SeriesNotFound() {
        // Test update with non-existent series ID
        boolean updateResult = TVProject.updateSeriesForTesting("999", "New Series", "12", "10");
        
        assertFalse(updateResult);
    }
    
    @Test
    public void TestDeleteSeries() {
        // Test that series is successfully deleted
        int initialSize = TVProject.getSeriesListSizeForTesting();
        boolean deleteResult = TVProject.deleteSeriesByIdForTesting("101");
        
        assertTrue(deleteResult);
        assertEquals(initialSize - 1, TVProject.getSeriesListSizeForTesting());
        
        // Verify the series is gone
        SeriesModel deletedSeries = TVProject.searchSeriesById("101");
        assertNull(deletedSeries);
    }
    
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        // Test delete with non-existent series ID
        int initialSize = TVProject.getSeriesListSizeForTesting();
        boolean deleteResult = TVProject.deleteSeriesByIdForTesting("999");
        
        assertFalse(deleteResult);
        assertEquals(initialSize, TVProject.getSeriesListSizeForTesting());
    }
    
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        // Test valid age restrictions
        assertTrue(TVProject.isAgeValid("2"));
        assertTrue(TVProject.isAgeValid("12"));
        assertTrue(TVProject.isAgeValid("18"));
        assertTrue(TVProject.isAgeValid("10"));
    }
    
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInvalid() {
        // Test invalid age restrictions
        assertFalse(TVProject.isAgeValid("1"));    // Below minimum
        assertFalse(TVProject.isAgeValid("19"));   // Above maximum
        assertFalse(TVProject.isAgeValid("0"));    // Below minimum
        assertFalse(TVProject.isAgeValid("20"));   // Above maximum
        assertFalse(TVProject.isAgeValid("abc"));  // Non-numeric
        assertFalse(TVProject.isAgeValid(""));     // Empty string
    }
    
    
    public TVProjectTest() {
    }
    
}
