package concurrency.prodcons;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread runner1 = new Thread(() -> {
            Thread.currentThread().setName("producer");
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    Thread runner2 = new Thread(new Runnable() {
        @Override
        public void run() {
            Thread.currentThread().setName("consumer");
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


        runner1.start();
        runner2.start();
    }
}
