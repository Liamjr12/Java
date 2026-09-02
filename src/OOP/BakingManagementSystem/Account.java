package OOP.BakingManagementSystem;

public class Account {
    private int accountNumber;
    private int accountPassword;
    private double loan;
    private double balance;

    public Account(int accountNumber, int accountPassword) {
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.loan = 0;
        this.balance = 0;
    }

    public Account() {}

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAccountPassword() {
        return accountPassword;
    }

    public double getLoan() {
        return loan;
    }

    public double getBalance() {
        return balance;
    }

    public void setLoan(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than 0.");
        }

        if (loan + amount > 10_000) {
            throw new IllegalArgumentException("You cannot borrow more than Php10,000.");
        }

        loan += amount;
        balance += amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }

        double interest = balance * 0.03;
        balance = (balance + amount) - interest;
    }

    public void deposit(Account account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }

        double interest = balance * 0.03;
        account.balance += amount;
    }

    public void withdraw(double amount) {
        if (balance <= 0) {
            throw new IllegalArgumentException("You can no longer extract a money from the bank");
        }

        double interest = balance * 0.03;
        balance = (balance - amount) - interest;
    }

    public void transfer(Account account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to be transfer must be greater than 0.");
        }

        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance to transfer the amount");
        }

        withdraw(amount);
        deposit(account, amount);
    }

    public void payLoan(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0.");
        }

        if (amount > loan) {
            double excess = amount - loan;
            balance += excess;
            loan = 0;
        } else {
            loan -= amount;
        }

        balance -= amount;
    }
}