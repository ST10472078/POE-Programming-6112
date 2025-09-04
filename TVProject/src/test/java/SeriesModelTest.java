/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.yourcompany.tvproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class SeriesModelTest {
    
    @Test
    public void testSeriesModelCreation() {
        SeriesModel series = new SeriesModel("101", "Extreme Sports", "12", "10");
        
        assertEquals("101", series.seriesId);
        assertEquals("Extreme Sports", series.seriesName);
        assertEquals("12", series.seriesAge);
        assertEquals("10", series.seriesNumberOfEpisodes);
    }
    
    public SeriesModelTest() {
    }
    
}
