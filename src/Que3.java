public class Que3 {
/*
3. Implement a java program that creates and starts a thread to perform a specific task.
inside the thread, use run(_) method, use yield( ) to give up the CPU momentarily,
use sleep( ) to stop the thread execution for a specific amount of time.
Demonstrate the use of stop() method to stop the thread abruptly.

*/
    public static void main(String[] args) {
        TestThread t1 = new TestThread();
        OtherThread t2 = new OtherThread();
        t1.start();
        t2.start();
        t1.yield();
//        t1.stop();



    }
}

class TestThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class OtherThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread 1 has given up the CPU momentarily");
        }
    }
}
