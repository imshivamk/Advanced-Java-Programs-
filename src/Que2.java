public class Que2 {
/*
    2. Java program to demonstrate concurrent execution of three threads using the runnable interface.
    task 1 : print odd numbers from 1 to 20 ,
    task 2: print the uppercase alphabets from a to e and the
    task 3 : print the lowercase alphabets from a to e.
*/
    public static void main(String[] args) {
        Thread t1 = new Thread(new printOdd());
        Thread t2 = new Thread(new printUpperCase());
        Thread t3 = new Thread(new printLowerCase());

        t1.start();
        t2.start();
        t3.start();
    }
}

class printOdd implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 20 ; i++) {
            if (i%2!=0) System.out.println(i);
        }
    }
}

class printUpperCase implements Runnable{
    @Override
    public void run() {
        char[] atoe = {'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < 5; i++) {
            System.out.println(atoe[i]);
        }
    }
}

class printLowerCase implements Runnable{
    @Override
    public void run() {
        char[] atoe = {'a', 'b', 'c', 'd', 'e'};
        for (int i = 0; i < 5; i++) {
            System.out.println(atoe[i]);
        }
    }
}
