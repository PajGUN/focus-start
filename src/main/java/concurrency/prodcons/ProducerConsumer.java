package concurrency.prodcons;

import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    private int count = 0;
    private Semaphore semaphore = new Semaphore(1);


    public void produce() throws InterruptedException {
        while (true) {
            semaphore.acquire();
            while (count <= 9){
                System.out.println(Thread.currentThread().getName() + " " +  count++ + " ");
                Thread.sleep(500);
            }
            semaphore.release();
        }
    }


    public void consume() throws InterruptedException {
        while (true) {
            semaphore.acquire();
                while (count >= 1) {
                    System.out.println(Thread.currentThread().getName() + " "+ count-- );
                    Thread.sleep(500);
                }
            semaphore.release();
        }
    }
}

