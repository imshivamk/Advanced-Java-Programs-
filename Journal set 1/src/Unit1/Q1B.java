package Unit1;

// a) Create two Threads T1 and T2 where T1 will print Uppercase
// alphabets from A to E and T2 will print Lowercase alphabets from a to e.
public class Q1B {
    public static void main(String[] args) {
        Thread t1 = new Thread(new UpperCasePrinter());
        Thread t2 = new Thread(new LowerCasePrinter());
        t1.start();
        t2.start();
    }
}

class UpperCasePrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        System.out.println("D");
        System.out.println("E");
    }
}

class LowerCasePrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
        System.out.println("d");
        System.out.println("e");
    }
}