package OOP.BakingManagementSystem;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;

public class Account {
    private static final double TRANSFER_LIMIT = 100_000;
    private double balance;
    private Transaction transaction;
    private Map<Integer, String> account = new LinkedHashMap<>();

    public Account(Map<Integer, String> account, double balance) {
        if (account == null || account.isEmpty()) {
            throw new IllegalArgumentException("The account details cannot be empty.");
        }

        if (account.keySet().iterator().next()<=0) {
            throw new IllegalArgumentException("Account number must be unique positive number");
        }

        if (balance<0) {
            throw new IllegalArgumentException("The balance cannot be less than 0.");
        }

        this.account = account;
        this.balance = balance;
    }

    public Account(){}

    public int getAccountNumber() {
        return account.keySet().iterator().next();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount<=0) {
            throw new IllegalArgumentException("You cannot deposit an amount less than or equal to 0.");
        }

        balance+=amount;
        transaction.depositTransactions(amount);
    }

    public void withdraw(double amount) {
        if (amount<=0) {
            throw new IllegalArgumentException("You cannot withdraw an amount less than or equal to 0.");
        }

        if (balance<amount) {
            throw new IllegalArgumentException("You cannot withdraw a money more than your current balance.");
        }

        balance-=amount;
        transaction.withdrawTransactions(amount);
    }

    public void transfer(Account receiver, double amount) {
        if (receiver == null) {
            throw new IllegalArgumentException("The receiver's credentials does not exist in the bank system");
        }

        if (receiver == this) {
            throw new IllegalArgumentException("You cannot send your money to your own self. Please try again.");
        }

        if (amount<=0) {
            throw new IllegalArgumentException("You cannot transfer a money less than or equal to 0.");
        }

        if (balance<amount) {
            throw new IllegalArgumentException("You cannot transfer a money more than your current balance.");
        }

        if (amount>TRANSFER_LIMIT) {
            throw new IllegalArgumentException("You can only transfer Php100,000 per session. Please try again.");
        }

        balance-=amount;
        receiver.balance+=amount;

        transaction.transferTransactions(ACCOUNT_TYPE.SENDER, amount);
        receiver.transaction.transferTransactions(ACCOUNT_TYPE.RECEIVER, amount);
    }

    public void displayTransactions() {
        transaction.displayTransactions();
    }
}