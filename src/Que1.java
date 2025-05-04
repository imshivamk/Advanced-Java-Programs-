public class Que1 {
//    1. write a java program to create three threads using the thread class and run them concurrently. each performing a different task.
//    task 1 : calculate the factoirial of a number
//    task 2: print the even numbers from 1 to 10,
//    task 3: calculate the sum of digits of a given number.

    public static void main(String[] args) {
        factorialThread t1 = new factorialThread(5);
        evenThread t2 = new evenThread();
        sumOfDigits t3 = new sumOfDigits(123);

        t1.start();
        t2.start();
        t3.start();

    }
}

class factorialThread extends Thread{
    int num;
    public factorialThread(int num){
        this.num = num;
    }

    @Override
    public void run() {
        int f = 1;
        for (int i = 1; i <= num ; i++) {
            f = f * i;
        }
        System.out.println(f);
    }
}

class evenThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}

class sumOfDigits extends Thread{
    int num;
    public sumOfDigits(int num){
        this.num = num;
    }
    @Override
    public void run() {
        int sum = 0;
        while (num!=0){
            sum += num%10;
            num/=10;
        }
        System.out.println(sum);
    }
}
