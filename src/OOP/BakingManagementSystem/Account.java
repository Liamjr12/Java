package OOP.BakingManagementSystem;

import java.util.Map;
import java.util.HashMap;

public class Account {
    private Map<Integer, String> accountDetails = new HashMap<>();
    private double loan;
    private double balance;

    public Account(Map<Integer, String> accountDetails) {
        this.accountDetails = accountDetails;
        this.loan = 0;
        this.balance = 0;
    }

    public Account() {}

    public int getAccountNumber() {
        for (int key:accountDetails.keySet()) {
            return key;
        }
        return 0;
    }

    public String getAccountPassword() {
        for (String value : accountDetails.values()) {
            return value;
        }
        return null;
    }

    public double getLoan() {
        return loan;
    }

    public double getBalance() {
        return balance;
    }

    private void applyInterest() {
        double interest = balance*0.03;
        balance+=interest;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }

        balance+=amount;

        if (amount >= 10_000) {
            applyInterest();
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }

        if (balance < amount) {
            throw new IllegalArgumentException("You can no longer extract a money from the bank");
        }

        balance-=amount;

        if (amount >= 10_000) {
            applyInterest();
        }
    }

    public void transfer(Account account, double amount) {
        withdraw(amount);
        account.deposit(amount);

        if (amount >= 10_000) {
            applyInterest();
        }
    }

    public void makeLoan(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than 0.");
        }

        if (loan+amount > 10_000) {
            throw new IllegalArgumentException("You cannot have more than Php10,000 in outstanding loans.");
        }

        loan+=amount;
        balance+=amount;
    }

    public void payLoan(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0.");
        }

        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance to pay the loans");
        }

        if (amount > loan) {
            double excess = amount-loan;
            balance-=loan;
            loan = 0;
            balance+=excess;
        }
        else {
            balance-=amount;
            loan-=amount;
        }
    }
}