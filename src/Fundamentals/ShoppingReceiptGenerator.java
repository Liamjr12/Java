package Fundamentals;

import java.util.Scanner;

public class ShoppingReceiptGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Product name: ");
            String productName = scanner.nextLine();

            if (productName.isBlank()) {
                System.out.println("Invalid input");
                scanner.close();
            }

            System.out.print("Item price: ");
            double itemPrice = Double.parseDouble(scanner.nextLine());

            System.out.print("Item quantity: ");
            int itemQuantity = Integer.parseInt(scanner.nextLine());

            System.out.print("Item discount: ");
            double itemDiscount = Double.parseDouble(scanner.nextLine());
            double dp = itemDiscount/100;

            System.out.print("VAT: ");
            double valueAddedTax = Double.parseDouble(scanner.nextLine());
            double tax = valueAddedTax/100;

            System.out.println("\n===== RECEIPT =====");

            double DiscountAmount = (itemPrice*itemQuantity) * (1-dp);
            System.out.println("Discount amount: " + DiscountAmount);

            double VAT = DiscountAmount*tax;

            double GrandTotal = DiscountAmount + VAT;
            System.out.println("Grand-total: " + GrandTotal);

            scanner.close();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }

    }
}
