package com.company.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BarrierExample {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("Ferry  sails");
            }
        });
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(random.nextInt(500));

                        System.out.println(Thread.currentThread().getName() + " "
                                + " close to ferry");
                        cyclicBarrier.await(10, TimeUnit.SECONDS);
//                        System.out.println(Thread.currentThread().getName() + " "
//                                + " on the ferry");
                        Thread.sleep(500);
//                        System.out.println(Thread.currentThread().getName() + " "
//                                + " out of the tunnel");
                    } catch (InterruptedException | BrokenBarrierException | TimeoutException ex) {
                        System.out.println("EX " + ex.getMessage());
                    } finally {

                    }


                }
            });
            thread.start();

        }



    }
}

