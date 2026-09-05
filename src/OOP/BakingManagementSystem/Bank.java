package OOP.BakingManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bank {
    private List<Account> accountList = new ArrayList<>();

    public void displayAccounts() {
        System.out.println("*******ACCOUNT LIST*******");
        int i = 0;
        for (Account a : accountList) {
            System.out.println((i++) + ". " + a);
        }
    }

    public void addAccount(Map<Integer, String> accountDetails, double amount) {
        int accountNumber = accountDetails.keySet().iterator().next();
        Account existingAccount = isFound(accountNumber);

        if (accountDetails.keySet().iterator().next().equals(existingAccount)) {
            throw new IllegalArgumentException("The credentials matched to the exisiting account in the bank system.");
        }

        if (amount<0) {
            throw new IllegalArgumentException("You cannot make an account with negative starting amount");
        }

        Account account = new Account(accountDetails, amount);
    }

    public void removeAccount(int accountNumber) {
        if (accountNumber<0) {
            throw new IllegalArgumentException("No less than 0 account number exist in the bank system.");
        }

        Account account = isFound(accountNumber);
        accountList.remove(account);
    }

    public void findAccount(int accountNumber) {
        Account account = isFound(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("There is no such account number exists in the bank system.");
        }

        System.out.println("Account has been found: " + account.getAccountNumber());
    }

    private Account isFound(int accountNumber) {
        if (accountNumber<0) {
            throw new IllegalArgumentException("No less than 0 account number exist in the bank system.");
        }

        for (Account a : accountList) {
            if (a.getAccountNumber()==accountNumber) {
                return a;
            }
        }
        return null;
    }
}