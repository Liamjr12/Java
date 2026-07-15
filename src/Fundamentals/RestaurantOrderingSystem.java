package Fundamentals;

import java.util.Scanner;

public class RestaurantOrderingSystem {
    enum Selection {
        BURGER, FRIES, SODA, JUICE, WATER;
    }
    
    public static void main(String[] args) throws Exception{

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String orders = readString(scanner, "\nEnter order: ");
                int quantity = readInt(scanner, "Quantity: ");
                double discount = readDouble(scanner, "Discount: ");
                boolean isMinor = readBoolean(scanner, "Minor? ");
                boolean isDefect = readBoolean(scanner, "PWD? ");

                System.out.println("\n===== TRANSACTION =====");
                getOrdersPrice(orders, quantity, discount, isMinor, isDefect);
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                scanner.close();
            } 
        }
    }

    private static void getOrdersPrice(String order, int quantity, double discount, boolean isMinor, boolean isDefect) {
        double price = getOrders(order);

        double subtotal = price*quantity;
        double priceDiscount = subtotal*(discount/100);
        double seniorDiscount = (isMinor != true) ? subtotal*0.20 : 0;
        double defectDiscount = (isMinor != true) ? subtotal*0.20 : 0;
        double totalDiscount = priceDiscount + seniorDiscount + defectDiscount;
        double VAT = (subtotal - totalDiscount)*0.12;
        double GrandTotal = (subtotal - totalDiscount) + VAT;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total Discount: " + totalDiscount);
        System.out.println("VAT: " + VAT);
        System.out.println("Grand Total: " + GrandTotal);
    }

    private static double getOrders(String order) {
        Selection orders = Selection.valueOf(order.toUpperCase().trim());

        return switch(orders) {
            case Selection.BURGER -> 90.50;
            case Selection.FRIES -> 50.25;
            case Selection.SODA -> 75.99;
            case Selection.JUICE -> 89.99;
            case Selection.WATER -> 10.00;
        };
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (!input.matches("\\d{1,}")) {
            throw new IllegalArgumentException("An input only accept an integer");
        }

        return Integer.parseInt(input);
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (!input.matches("\\d{1,}")) {
            throw new IllegalArgumentException("An input only accept an integer");
        }

        return Double.parseDouble(input);
    }

    private static boolean readBoolean(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (input.equalsIgnoreCase("Yes")) {
            return true;
        }

        return false;
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (input.matches(".*[^a-zA-Z].*")) {
            throw new IllegalArgumentException("The input must only contain a letters");
        }

        return input;
    }

}
