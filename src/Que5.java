/*
5. Implement a java program that creates and starts multiple threads with multiple priorities.


 */
public class Que5 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("Thread A"), "Thread A");
        Thread t2 = new Thread(new Task("Thread B"), "Thread B");
        Thread t3 = new Thread(new Task("Thread C"), "Thread C");

        // Setting different priorities
        t1.setPriority(Thread.NORM_PRIORITY - 1);  // Priority 4
        t2.setPriority(Thread.MAX_PRIORITY);      // Priority 10
        t3.setPriority(Thread.MIN_PRIORITY);      // Priority 2

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}

class Task implements Runnable {
    private String threadName;

    public Task(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i <= 10_000_000L; i++) {
            sum += i;
        }
        System.out.println(threadName + " completed with sum: " + sum);
    }
}
