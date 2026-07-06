package Fundamentals;

import java.util.Scanner;

public class RestaurantOrderingSystem {

    enum Selection {
        BURGER, FRIES, SODA, JUICE, WATER;
    }
    
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter order: ");
                String orders = scanner.nextLine();

                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                System.out.print("Discount: ");
                double discount = Double.parseDouble(scanner.nextLine());

                System.out.print("Minor?: ");
                boolean isMinor = Boolean.parseBoolean(scanner.nextLine());

                System.out.print("PWD?: ");
                boolean isDefect = Boolean.parseBoolean(scanner.nextLine());
                getOrdersPrice(orders, quantity, discount, isMinor, isDefect);

            } catch(NumberFormatException e) {
                System.out.println("Invalid input");
                scanner.close();
            } 
        }
    }

    public static void getOrdersPrice(String order, int quantity, double discount, boolean isMinor, boolean isDefect) {
        double price = getOrders(order);

        double subtotal = price*quantity;
        double priceDiscount = subtotal*(discount/100);
        double seniorDiscount = (isMinor != true) ? subtotal*0.20 : 0;
        double defectDiscount = (isMinor != true) ? subtotal*0.20 : 0;
        double totalDiscount = priceDiscount + seniorDiscount + defectDiscount;
        double VAT = (subtotal - totalDiscount)*0.12;
        double GrandTotal = (subtotal - totalDiscount) + VAT;

        System.out.println("===== TRANSACTION =====");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total Discount: " + totalDiscount);
        System.out.println("VAT: " + VAT);
        System.out.println("Grand Total: " + GrandTotal);
    }

    private static double getOrders(String order) {
        Selection orders = Selection.valueOf(order.toUpperCase());

        switch(orders) {
            case Selection.BURGER -> {
                return 90.50;
            } 
            case Selection.FRIES -> {
                return 50.25;
            }
            case Selection.SODA -> {
                return 75.99;
            }
            case Selection.WATER -> {
                return 10.00;
            }
            default -> System.out.println("Invalid input");
        } 

        return 0.0;
    }

}