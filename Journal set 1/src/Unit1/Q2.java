package Unit1;

//2.	Implement Thread synchronization in a banking system where there are three Threads- Totalbalance,
// Withdraw, Deposit. Demonstrating transaction in a bank to be carried out concurrently.


class Account{
    double balance = 0;

    public Account(double balance){
        this.balance = balance;
    }
    public  Account(){

    }

    synchronized void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount + " | Balance:  " + balance);
    }

    synchronized void withdraw(double amount) {
        if(balance >=amount ) {
            balance= balance - amount;
            System.out.println("withdraw: " + amount + "| Balance: " + balance);
        }
        else {
            System.out.println("Insufficient Balance! Withdrawal of " + amount + " failed.");

        }
    }

    synchronized void showBalance() {
        System.out.println("Current Balance: " + balance );
    }

}

class DepositThread extends Thread {

    Account account;
    double amount;

    public DepositThread(Account acc,double amount) {
        this.account = acc;
        this.amount = amount;
    }

    public void run() {
        account.deposit(amount);
    }
}

class WithdrawThread extends Thread{
    Account account;
    double amount;

    public WithdrawThread(Account account, double amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

class BalanceThread extends Thread {
    Account account;
    public BalanceThread(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        account.showBalance();
    }
}
public class Q2 {

    public static void main(String[] args) {

        Account shivam = new Account(1000);
        Account deven = new Account();
        Account arnav = new Account(500);

        DepositThread t1 = new DepositThread(shivam, 2000);
        DepositThread t2 = new DepositThread(arnav, 3000);
        DepositThread t3 = new DepositThread(shivam, 500);
        WithdrawThread t4 = new WithdrawThread(arnav, 500);
        WithdrawThread t5 = new WithdrawThread(shivam, 5000);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


//        try {
//            t1.join();
//            t2.join();
//            t3.join();
//            t4.join();
//            t5.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }

}