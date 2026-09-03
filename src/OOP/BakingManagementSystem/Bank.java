package OOP.BakingManagementSystem;

import java.util.*;

public class Bank extends Account {
    private List<Account> accountList = new ArrayList<>();

    public Bank(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Bank() {}

    public void displayAccountList() {
        int i = 0;

        for (Account a:accountList) {
            System.out.println((i++) + ". " + a.getAccountNumber());
        }
    }

    public void addAccount(Map<Integer, String> accountDetails) {
        if (accountDetails==null || accountDetails.isEmpty()) {
            throw new IllegalArgumentException("Account details cannot be empty.");
        }

        int newAccountNumber = accountDetails.keySet().iterator().next();

        for (Account account : accountList) {
            if (account.getAccountNumber() == newAccountNumber) {
                throw new IllegalArgumentException("The account number already exists. Please try again.");
            }
        }

        Account account = new Account(accountDetails);
        accountList.add(account);
    }

    public void removeAccount(Map<Integer, String> accountDetails) {
        if (accountList == null || accountList.isEmpty()) {
            throw new IllegalArgumentException("Account list is empty.");
        }

        if (accountDetails == null || accountDetails.isEmpty()) {
            throw new IllegalArgumentException("Account details cannot be empty.");
        }

        int accountNumber = accountDetails.keySet().iterator().next();
        Iterator<Account> iterator = accountList.iterator();

        while (iterator.hasNext()) {
            Account account = iterator.next();

            if (account.getAccountNumber() == accountNumber) {
                iterator.remove();
                return;
            }
        }

        throw new IllegalArgumentException("Account number does not exist.");
    }

    public boolean findAccount(int accountNumber, String accountPassword) {
        for (Account a : accountList) {
            if (accountNumber == a.getAccountNumber()
                    && accountPassword.equals(a.getAccountPassword())) {
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
}