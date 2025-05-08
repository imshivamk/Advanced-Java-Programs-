package Unit1;

public class Q1 {

    public static void main(String[] args) {
        FactorialThread t1 = new FactorialThread(5);
        SumThread t2 = new SumThread(123);

        t1.start();
        t2.start();
    }


}

class FactorialThread extends Thread{
    int num;
    public FactorialThread(int num){
        this.num = num;
    }

    @Override
    public void run() {


        // factorila
        int f = 1;
        for (int i = 1; i <= num ; i++) {
            f = f * i;
        }

        System.out.println(f);
    }
}
class SumThread extends Thread{
    int num;
    public SumThread(int num){
        this.num = num;
    }

    @Override
    public void run() {

        int sum =  0;
        while (num!=0){
            sum += num%10;
            num /= 10;
        }

        System.out.println(sum);
    }
}

