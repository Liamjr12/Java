package Fundamentals;

import java.util.Scanner;

public class ShoppingReceiptGenerator {
    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("\nProduct name: ");
                String productName = scanner.nextLine().trim();

                if (productName.isBlank()) {
                    System.out.println("Please add your product first");
                    continue;
                }

                if (productName.equalsIgnoreCase("Exit")) {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }

                System.out.print("Price: ");
                double productPrice = readDouble(scanner);

                System.out.print("Quantity: ");
                int productQuantity = readInt(scanner);

                System.out.print("Discount: ");
                double productDiscount = readDouble(scanner);

                System.out.print("VAT: ");
                double productVAT = readDouble(scanner);

                System.out.println("\n===== SHOPPING RECEIPT =====");
                getShoppingReceipt(productName, productPrice, productQuantity, productDiscount, productVAT);
                
            } catch(NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static void getShoppingReceipt(String productName, double productPrice, int productQuantity, double productDiscount, double productVAT) {
        double discountPercentage = productDiscount/100;
        double VATpercentage = productVAT/100;

        double subtotal = productPrice*productQuantity;
        double discount = subtotal*discountPercentage;
        double vat = (subtotal - discount)*VATpercentage;
        double GrandTotal = subtotal - discount + vat;

        System.out.println("Product name: " + productName);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("VAT: " + vat);
        System.out.println("Grand total: " + GrandTotal);
    }

    private static int readInt(Scanner scanner) {
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (input.matches("\\d{1,4}")) {
            throw new IllegalArgumentException("An input must only contain a numbers");
        }

        int parsedInt = Integer.parseInt(input);
        return parsedInt;
    }

    private static double readDouble(Scanner scanner) {
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (input.matches("\\d{1,4}")) {
            throw new IllegalArgumentException("An input must only contain a numbers");
        }

        double parsedDouble = Double.parseDouble(input);
        return parsedDouble;
    }
}