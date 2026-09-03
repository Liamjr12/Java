package OOP.BakingManagementSystem;

public class Master {
    public static void main(String[] args) {
        Account me = new Account();
        Account friend = new Account();

        me.deposit(10000);
        me.deposit(1000);
        me.withdraw(1000);
        me.withdraw(10000);
        me.withdraw(100);
        me.transfer(friend, 100);
        me.makeLoan(1000);
        System.out.println("My Balance: " + me.getBalance());
        System.out.println("My Loan: " + me.getLoan());
        //System.out.println("Friend Balance: " + friend.getBalance());
    }
}
