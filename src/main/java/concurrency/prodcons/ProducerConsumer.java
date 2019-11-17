package concurrency.prodcons;

public class ProducerConsumer {

    private int count = 0;

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                 while (count > 9) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " " +  count++ + " ");
                Thread.sleep(500);
                notify();
            }
        }
    }


    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (count <= 1) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " "+ count-- );
                Thread.sleep(500);
                notify();
            }
        }
    }
}

