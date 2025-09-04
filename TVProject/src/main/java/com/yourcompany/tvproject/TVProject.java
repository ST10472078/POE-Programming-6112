/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.yourcompany.tvproject;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author lab_services_student
 */
public class TVProject {
    
    private static ArrayList<SeriesModel> seriesList = new ArrayList<>(); 
    private static Scanner scanner = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        System.out.println("=== WELCOME TO LATEST SERIES - 2025 ===");
        launchMenu();
    }
    
    public static void launchMenu() {
        while (true) {
            System.out.println("\n=== LATEST SERIES - 2025 ===");
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");
            System.out.print("Enter your choice (1-6): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number 1-6.");
                continue;
            }
            
            switch (choice) {
                case 1: CaptureSeries(); break;
                case 2: SearchSeries(); break;
                case 3: UpdateSeries(); break;
                case 4: DeleteSeries(); break;
                case 5: SeriesReport(); break;
                case 6: ExitSeriesApplication(); return;
                default: System.out.println("Invalid choice! Please enter 1-6.");
            }
        }
    }
    
    // ===== MAIN FUNCTIONALITY METHODS =====
    
    public static void CaptureSeries() {
        System.out.println("\n=== CAPTURE A NEW SERIES ===");
        
        System.out.print("Enter the series id: ");
        String seriesId = scanner.nextLine();
        
        System.out.print("Enter the series name: ");
        String seriesName = scanner.nextLine();
        
        String seriesAge;
        while (true) {
            System.out.print("Enter the series age restriction (2-18): ");
            seriesAge = scanner.nextLine();
            
            try {
                int age = Integer.parseInt(seriesAge);
                if (age < 2 || age > 18) {
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.println("Please re-enter the series age >>");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.println("Please re-enter the series age >>");
            }
        }
        
        System.out.print("Enter the number of episodes for " + seriesName + ": ");
        String episodes = scanner.nextLine();
        
        SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, episodes);
        seriesList.add(newSeries);
        
        System.out.println("Series processed successfully!!!");
    }
    
    public static void SearchSeries() {
        System.out.println("\n=== SEARCH FOR A SERIES ===");
        
        System.out.print("Enter the series id to search: ");
        String searchId = scanner.nextLine();
        
        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(searchId)) {
                System.out.println("\n=== SERIES FOUND ===");
                System.out.println("SERIES ID: " + series.seriesId);
                System.out.println("SERIES NAME: " + series.seriesName);
                System.out.println("SERIES AGE RESTRICTION: " + series.seriesAge);
                System.out.println("SERIES NUMBER OF EPISODES: " + series.seriesNumberOfEpisodes);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series with Series Id: " + searchId + " was not found!");
        }
    }
    
    public static void UpdateSeries() {
        System.out.println("\n=== UPDATE SERIES ===");
        
        System.out.print("Enter the series id to update: ");
        String updateId = scanner.nextLine();
        
        SeriesModel foundSeries = null;
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(updateId)) {
                foundSeries = series;
                break;
            }
        }
        
        if (foundSeries == null) {
            System.out.println("Series with Series Id: " + updateId + " was not found!");
            return;
        }
        
        System.out.print("Enter the series name [" + foundSeries.seriesName + "]: ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            foundSeries.seriesName = newName;
        }
        
        String newAge;
        while (true) {
            System.out.print("Enter the age restriction [" + foundSeries.seriesAge + "]: ");
            newAge = scanner.nextLine();
            
            if (newAge.isEmpty()) {
                break; // Keeps the current value
            }
            
            try {
                int age = Integer.parseInt(newAge);
                if (age < 2 || age > 18) {
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.println("Please re-enter the series age >>");
                    continue;
                }
                foundSeries.seriesAge = newAge;
                break;
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.println("Please re-enter the series age >>");
            }
        }
        
        System.out.print("Enter the number of episodes [" + foundSeries.seriesNumberOfEpisodes + "]: ");
        String newEpisodes = scanner.nextLine();
        if (!newEpisodes.isEmpty()) {
            foundSeries.seriesNumberOfEpisodes = newEpisodes;
        }
        
        System.out.println("Series updated successfully!");
    }
    
    public static void DeleteSeries() {
        System.out.println("\n=== DELETE SERIES ===");
        
        System.out.print("Enter the series id to delete: ");
        String deleteId = scanner.nextLine();

        SeriesModel foundSeries = null;
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(deleteId)) {
                foundSeries = series;
                break;
            }
        }

        if (foundSeries == null) {
            System.out.println("Series with Series Id: " + deleteId + " was not found!");
            return;
        }

        System.out.print("Are you sure you want to delete series " + deleteId + " from the system? (yes/no): ");
        String confirm = scanner.nextLine().toLowerCase();

        if (confirm.equals("yes") || confirm.equals("y")) {
            seriesList.remove(foundSeries);
            System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    
    public static void SeriesReport() {
        System.out.println("\n=== SERIES REPORT - 2025 ===");
        
        if (seriesList.isEmpty()) {
            System.out.println("No series data available!");
            return;
        }
        
        System.out.println("****************************");
        for (SeriesModel series : seriesList) {
            System.out.println("SERIES ID: " + series.seriesId);
            System.out.println("SERIES NAME: " + series.seriesName);
            System.out.println("SERIES AGE RESTRICTION: " + series.seriesAge);
            System.out.println("NUMBER OF EPISODES: " + series.seriesNumberOfEpisodes);
            System.out.println("****************************");
        }
    }
    
    public static void ExitSeriesApplication() {
        System.out.println("Thank you for using the TV Series Management Application!");
        System.exit(0);
    }
    
    //Test Helper Methods(These methods assist in the unit testing to avoid unnecessary errors
    
    public static void clearSeriesListForTesting() {
        seriesList.clear();
    }
    
    //Adds a series for testing
    public static void addSeriesForTesting(SeriesModel series) {
        seriesList.add(series);
    }
    
    //Searches for a series by ID (for testing)
    public static SeriesModel searchSeriesById(String id) {
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(id)) {
                return series;
            }
        }
        return null;
    }
    
    //Updates a series for testing
    public static boolean updateSeriesForTesting(String id, String newName, String newAge, String newEpisodes) {
        SeriesModel series = searchSeriesById(id);
        if (series != null) {
            series.seriesName = newName;
            series.seriesAge = newAge;
            series.seriesNumberOfEpisodes = newEpisodes;
            return true;
        }
        return false;
    }
    
    //Deletes a series by ID for testing   
    public static boolean deleteSeriesByIdForTesting(String id) {
        SeriesModel series = searchSeriesById(id);
        if (series != null) {
            seriesList.remove(series);
            return true;
        }
        return false;
    }
    
    //the current size of the series list for testing    
    public static int getSeriesListSizeForTesting() {
        return seriesList.size();
    }
    
    // This validates age restriction for testing
    public static boolean isAgeValid(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue >= 2 && ageValue <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    //Captures a new series for testing   
    public static boolean captureSeriesForTesting(String id, String name, String age, String episodes) {
        try {
            SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
            seriesList.add(newSeries);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

//Reference List

/*ArrayList Class Documentation
Oracle. (2023). Class ArrayList<E>. Java Platform SE 17. [Online] Available at:
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html 
[Accessed 2 September 2025]. */

/*NetBeans IDE Documentation
Apache NetBeans. (2023). NetBeans IDE Documentation. [Online] Available at: 
https://netbeans.apache.org/kb/ 
[Accessed 3 September 2025]. */

//Joyce Farrell. 2016. Java Programming, 8th ed. Boston: Cengage Learning.


