/*package OOP.BakingManagementSystem;

import java.util.*;

public class Bank extends Account {
    private List<Account> accountList = new ArrayList<>();

    public Bank(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Bank() {}

    public void displayAccountList() {
        int i = 0;

        for (Account a : accountList) {
            System.out.println((i++) + ". " + a.getAccountNumber());
        }
    }

    public void addAccount(int accountNumber, int accountPassword) {
        for (Account a : accountList) {
            if (accountNumber == a.getAccountNumber()) {
                throw new IllegalArgumentException("The account number already exist. Please try again.");
            }
        }

        Account account = new Account(accountNumber, accountPassword);
        accountList.add(account);
    }

    public void removeAccount(int accountNumber) {
        for (Account a : accountList) {
            if (accountNumber == a.getAccountNumber()) {
                accountList.remove(a.getAccountNumber());
            }
        }
    }

    public boolean findAccount(int accountNumber, int accountPassword) {
        for (Account a : accountList) {
            if (accountNumber == a.getAccountNumber() && accountPassword == a.getAccountPassword()) {
                return true;
            }
        }

        return false;
    }

    public Account findAccount(int accountNumber) {
        for (Account a : accountList) {
            if (accountNumber == a.getAccountNumber()) {
                return a;
            }
        }

        return null;
    }
}*/