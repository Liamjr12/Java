package OOP.BakingManagementSystem;

import java.util.*;

public class Bank {
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

    public void addAccount(Map<Integer, String> account) {
        if (account==null) {
            throw new IllegalArgumentException("The account details cannot be empty.");
        }

        for (Account a : accountList) {
            if (a.getAccountNumber()==account.keySet().iterator().next()) {
                throw new IllegalArgumentException("The account already exist in the bank system");
            }
        }

        Account newAccount = new Account(account);
        accountList.add(newAccount);
    }

    public void removeAccount(Account account) {
        if (account==null) {
            throw new IllegalArgumentException("The account details cannot be empty.");
        }

        Iterator<Account> accounts = accountList.iterator();
        while (accounts.hasNext()) {
            Account a = accounts.next();
            if (a.getAccountNumber()==account.getAccountNumber()) {
                accounts.remove();
                return;
            }
        }

        throw new IllegalArgumentException("Account details is not in the bank system");
    }

    public Account findAccount(int accountNumber) {
        for (Account a : accountList) {
            if (a.getAccountNumber()==accountNumber) {
                return a;
            }
        }
        return null;
    }
}