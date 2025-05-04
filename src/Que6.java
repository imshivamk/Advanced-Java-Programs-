//6. implement a java program, demonstrating the transaction in a bank,
// can be carried out concurrently using thread synchronization.

class Account{
    private static int serialNo = 0;
    private static int branchCode = 102400;
    private String accountNo;
    private String firstName;
    private String lastName;
    private String name;
    private double balance;
    private int age;

    public Account(String firstName, String lastName, int age) {
        serialNo++;
        accountNo = "2303" + branchCode + serialNo;

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        this.name = firstName + " " + lastName;
    }

    public synchronized void withdraw(double amount){
        if (amount <= balance){
            balance-=amount;
            System.out.println(Thread.currentThread().getName() + " withdrawn " + amount + " Rs. New Balance: " + balance);
        }
        else {
            System.out.println("insufficient balance");
        }
    }
    public synchronized void deposit(double amount){
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + " Rs. New Balance: " + balance);
    }

    @Override
    public String toString() {
        return "account no : " + accountNo + "\n" + "name : " + firstName + "\n" + "age : " + age + "\n" + "current balance: " + balance + "\n";
    }
}


public class Que6 {
    public static void main(String[] args) {
        Account shivam = new Account("Shivam", "Kedar", 21);
        System.out.println("Initial Account Details:\n" + shivam);


        Thread t1 = new Thread(()-> shivam.deposit(10000), "Transaction-1");
        Thread t2 = new Thread(()-> shivam.withdraw(1200), "Transaction-2");
        Thread t3 = new Thread(()-> shivam.withdraw(5000), "Transaction-3");
        Thread t4 = new Thread(()-> shivam.deposit(10000), "Transaction-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }


        System.out.println(shivam);
    }
}
