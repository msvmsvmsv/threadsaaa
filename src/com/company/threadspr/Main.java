package com.company.threadspr;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static  int sum = 0;
    public static AtomicInteger sum1 = new AtomicInteger(0);

    public static final Result result = new Result();

    public void method() throws InterruptedException {
        ThreadGroup tg = new ThreadGroup("TG");
        tg.setMaxPriority(1);
        Result result = new Result();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running");
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(500);
                        System.out.println("Mythread " + i);
                        sum += i;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Mythread sum =  "+result.sum);
            }
        });
        thread.start();
        thread.join();
        System.out.println("Main sum "+sum);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread = new MyThread2(1);
        MyThread2 myThread2 = new MyThread2(2);

        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
//        myThread.finish();
//        myThread2.finish();
        System.out.println("end "+Main.sum);



////        try {
//            for (int i = 0; i < 100; i++) {
////                Thread.sleep(100);
//                System.out.println("main "+i);
//            }
////        } catch (InterruptedException ex){
////            ex.printStackTrace();
////        }
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");



//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread2 = new Thread(myRunnable);
//        thread2.start();
//        System.out.println("end");
//
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }
}
