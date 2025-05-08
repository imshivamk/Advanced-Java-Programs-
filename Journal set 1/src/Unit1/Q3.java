package Unit1;

public class Q3 {
    public static void main(String[] args) {
        SharedArea sharedArea = new SharedArea();
        Producer p = new Producer(sharedArea);
        Consumer c = new Consumer(sharedArea);

        p.start();
        c.start();

    }
}


class SharedArea{
    private int data;
    private  boolean empty = true;

    public synchronized void setValue(int data){
        while (!empty){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.data = data;
        System.out.println("Produced " + data);
        empty = false;
        notify();

    }

    public synchronized int getValue(){
        while (empty){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        empty = true;
        notify();
        return data;
    }


}





class Producer extends Thread{
    SharedArea sharedArea;
    public Producer(SharedArea sharedArea){
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            sharedArea.setValue(i);
        }
    }
}





class Consumer extends Thread{
    SharedArea sharedArea;

    public Consumer(SharedArea sharedArea){
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Consumed " + sharedArea.getValue());

        }
    }
}