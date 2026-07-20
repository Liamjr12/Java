package Fundamentals;

import java.util.Scanner;

public class RestaurantOrderingSystem {
    enum restaurantMenu {
        CHICKEN, BURGER, FRIES, FILLET, RICE, SANDWITCH, STEAK, SOUP, JUICE, SODA; 
    }
    private static int orderCount = 0;
    public static void main(String[] args) {
        
        final Scanner scanner = new Scanner(System.in);
        double[] expenses = new double[10];

        System.out.println("""
        \n******** RESTAURANT SYSTEM ********
        1. Make an order 
        2. Display orders
        3. Expensive order
        4. Budget order
        5. Total spent
        6. Exit""");

        while (true) {
            try {
                System.out.print("\nChoice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> makeAnOrder(scanner, expenses);
                    case 2 -> displayOrders(expenses);
                    case 3 -> System.out.println("Expensive order: " + findMaximumValue(expenses));
                    case 4 -> System.out.println("Cheap order: " + findMinimumValue(expenses));
                    case 5 -> System.out.println("Total expenses: " + totalExpenses(expenses));
                    case 6 -> {
                        System.out.println("Terminating program...");
                        scanner.close();
                        System.out.println("Program has been terminated");
                        System.exit(0);
                    }
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new RuntimeException("Returning...");
        }

        if (input.matches(".*[^a-zA-Z].*")) {
            throw new IllegalArgumentException("The input must only contain a letters");
        }

        return input;
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new RuntimeException("Returning...");
        }

        if (!input.matches("\\d{1,}")) {
            throw new IllegalArgumentException("An input only accept an integer");
        }


        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input only accepts numbers");
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new RuntimeException("Returning...");
        }

        if (!input.matches("\\d{1,}")) {
            throw new IllegalArgumentException("An input only accept an integer");
        }


        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input only accepts numbers");
        }
    }

    private static boolean readBoolean(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new RuntimeException("Returning...");
        }

        if (!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No")) {
            throw new IllegalArgumentException("Input only accepts yes or no");
        }

        return Boolean.parseBoolean(input);
    }

    private static double getMenuName(String order) {
        restaurantMenu menu = restaurantMenu.valueOf(order.trim().toUpperCase());

        return switch(menu) {
            case restaurantMenu.CHICKEN -> 90.80;
            case restaurantMenu.BURGER -> 75.50;
            case restaurantMenu.FRIES -> 35.45;
            case restaurantMenu.RICE -> 15.99;
            case restaurantMenu.FILLET -> 45.85;
            case restaurantMenu.STEAK -> 120.30;
            case restaurantMenu.SANDWITCH -> 25.75;
            case restaurantMenu.SOUP -> 10.00;
            case restaurantMenu.JUICE -> 25.50;
            case restaurantMenu.SODA -> 50.50;
        };
    }

    private static double makeAnOrder(Scanner scanner, double[] expenses) {
        String order = readString(scanner, "Enter order: ");
        int quantity = readInt(scanner, "Enter quantity: ");
        double discount = readDouble(scanner, "Enter discount: ");
        boolean isMinor = readBoolean(scanner, "Minor? ");
        boolean isDefect = readBoolean(scanner, "PWD? ");

        double price = getMenuName(order);
        double subtotal = price*quantity;
        double priceDiscount = subtotal*(discount/100);
        double seniorDiscount = (isMinor != true) ? subtotal*0.20 : 0;
        double defectDiscount = (isDefect != true) ? subtotal*0.20 : 0;
        double totalDiscount = priceDiscount + seniorDiscount + defectDiscount;
        double VAT = (subtotal - totalDiscount)*0.12;
        double GrandTotal = (subtotal - totalDiscount) + VAT;

        System.out.println("\n******** RECEIPT ********");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total Discount: " + totalDiscount);
        System.out.println("VAT: " + VAT);
        System.out.println("Grand Total: " + GrandTotal);

        return expenses[orderCount++] = GrandTotal;
    } 

    private static void displayOrders(double[] expenses) {
        int count = 1;
        System.out.println("******** ORDERS LIST ********");
        for (int i = 0; i < orderCount; i++) {
            System.out.println((count++) + ".Total: " + expenses[i]);
        }
    }

    private static double findMaximumValue(double[] expenses) {
        double max = expenses[0];

        for (int i = 1; i < orderCount; i++) {
            if (expenses[i] > max) {
                max = expenses[i];
            }
        }
        
        return max;
    }

    private static double findMinimumValue(double[] expenses) {
        double min = expenses[0];
        
        for (int i = 1; i < orderCount; i++) {
            if (expenses[i] < min) {
                min = expenses[i];
            }
        }

        return min;
    }

    private static double totalExpenses(double[] expenses) {
        double sum = 0;
        
        for (int i = 0; i < orderCount; i++) {
            sum += expenses[i];
        }

        return sum;
    }
}