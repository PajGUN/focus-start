package concurrency.threads;

public class DifferentThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread good = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Good!");
            }
        });
        Thread bad = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Bad!");
            }
        });

        Thread evil = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Evil!");
            }
        });

        good.start();
        bad.start();
        evil.start();

    }
}
