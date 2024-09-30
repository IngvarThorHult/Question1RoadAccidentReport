package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of cities
        System.out.print("Enter the number of cities: ");
        int numCities = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        // Create arrays to store city names, accident data, and total accidents
        String[] cities = new String[numCities];
        int[][] carAccidents = new int[numCities][2];
        int[][] motorbikeAccidents = new int[numCities][2];
        int[] totalAccidents = new int[numCities];

        // Input city names and accident data
        for (int i = 0; i < numCities; i++) {
            System.out.print("Enter the name of city " + (i + 1) + ": ");
            cities[i] = scanner.nextLine().toUpperCase().trim();

            System.out.print("Enter the number of car accidents for " + cities[i] + ": ");
            carAccidents[i][0] = scanner.nextInt();
            carAccidents[i][1] = i; // Store index for sorting

            System.out.print("Enter the number of motorbike accidents for " + cities[i] + ": ");
            motorbikeAccidents[i][0] = scanner.nextInt();
            motorbikeAccidents[i][1] = i; // Store index for sorting

            // Consume the newline character after the integer input
            scanner.nextLine();

            // Calculate total accidents for each city
            totalAccidents[i] = carAccidents[i][0] + motorbikeAccidents[i][0];
        }

        // Sort the data by total accidents (descending order)
        sortDescending(totalAccidents, cities, carAccidents, motorbikeAccidents);

        // Print the report header
        System.out.println("\nROAD ACCIDENT REPORT");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-25s %-15s %-20s %-15s\n", "City", "Car Accidents", "Motorbike Accidents", "Total Accidents");
        System.out.println("---------------------------------------------------------");

        // Print the report details for each city
        for (int i = 0; i < numCities; i++) {
            System.out.printf("%-25s %-15d %-20d %-15d\n", cities[i], carAccidents[i][0], motorbikeAccidents[i][0], totalAccidents[i]);
        }
        // Print the road accident totals for each city and the city with the most accidents
        System.out.println("\nROAD ACCIDENT TOTALS FOR EACH CITY:");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < numCities; i++) {
            System.out.printf("%-25s %-15d\n", cities[i], totalAccidents[i]);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("CITY WITH THE MOST VEHICLE ACCIDENTS: " + cities[0]);
    }

    // Function to sort arrays by total accidents (descending order)
    public static void sortDescending(int[] totalAccidents, String[] cities, int[][] carAccidents, int[][] motorbikeAccidents) {
        int n = totalAccidents.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (totalAccidents[j] < totalAccidents[j + 1]) {
                    // Swap total accidents, city names, car accidents, and motorbike accidents
                    int temp = totalAccidents[j];
                    totalAccidents[j] = totalAccidents[j + 1];
                    totalAccidents[j + 1] = temp;

                    String tempCity = cities[j];
                    cities[j] = cities[j + 1];
                    cities[j + 1] = tempCity;

                    int[] tempCarAccidents = carAccidents[j];
                    carAccidents[j] = carAccidents[j + 1];
                    carAccidents[j + 1] = tempCarAccidents;

                    int[] tempMotorbikeAccidents = motorbikeAccidents[j];
                    motorbikeAccidents[j] = motorbikeAccidents[j + 1];
                    motorbikeAccidents[j + 1] = tempMotorbikeAccidents;
                }
            }
        }
    }
}
