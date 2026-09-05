package OOP.BakingManagementSystem;

import java.util.List;
import java.util.ArrayList;

enum ACCOUNT_TYPE {SENDER, RECEIVER}
public class Transaction extends Account {
    private List<String> transactions = new ArrayList<>();

    public void displayTransactions() {
        System.out.println("*******TRANSACTIONS*******");
        int i = 0;
        for (String t : transactions) {
            System.out.println((i++) + "." + t);
        }
    }

    public void depositTransactions(double amount) {
        String transaction = "BALANCE: Php" + getBalance() + " | DEPOSITED: Php" + amount;
        transactions.add(transaction);
        System.out.println("The deposit transaction is successful executed.");
    }

    public void withdrawTransactions(double amount) {
        String transaction = "BALANCE: Php" + getBalance() + " | WITHDRAWN: Php" + amount;
        transactions.add(transaction);
        System.out.println("The withdraw transaction is successful executed.");
    }

    public void transferTransactions(ACCOUNT_TYPE type, double amount) {
        String transaction = "BALANCE: Php" + getBalance() + " | " + type + ": Php" + amount;
        transactions.add(transaction);
        System.out.println("The transfer transaction is successful executed.");
    }
}