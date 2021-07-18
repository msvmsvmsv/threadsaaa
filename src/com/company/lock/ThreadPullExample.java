package com.company.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPullExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (i < 1) {
                        System.out.println("num:" + i + " " + Thread.currentThread().getName());
                        i++;
                    }
                }
            });
        }
        pool.shutdown();
        System.out.println("AAAAAAA");
        try {
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BBBBB");
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//                while (i < 1) {
//                    System.out.println("num:" + i + " " + Thread.currentThread().getName());
//                    i++;
//                }
//            }
//        });
    }
}
