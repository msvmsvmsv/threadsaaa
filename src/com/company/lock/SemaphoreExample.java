package com.company.lock;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    while(true){
                    try {
                        Thread.sleep(200);
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " "
                                + " in the tunnel");
                        Thread.sleep(new Random().nextInt(500));
                        System.out.println(Thread.currentThread().getName() + " "
                                + " out of the tunnel");
                    } catch (InterruptedException ex){
                        System.out.println("EX "+ex.getMessage());
                    } finally {
                        semaphore.release();
                    }


//                    }
                }
            });
            thread.start();

        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sem "+semaphore.availablePermits());
        System.out.println("sem "+semaphore.availablePermits());

    }
}
