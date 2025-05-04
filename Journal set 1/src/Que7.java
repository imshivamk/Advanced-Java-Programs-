class Shared {
    private boolean ready = false;

    public synchronized void produce() {
        System.out.println("Producing...");
        ready = true;
        notify(); // Wake up one waiting thread
    }

    public synchronized void consume() {
        while (!ready) {
            try {
                System.out.println("Waiting for production...");
                wait(); // Wait until notified
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed!");
        ready = false;
    }
}

public class Que7 {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Thread producer = new Thread(() -> shared.produce(), "Producer");
        Thread consumer = new Thread(() -> shared.consume(), "Consumer");

        consumer.start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        producer.start();
    }
}
