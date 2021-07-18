package com.company.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {


    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    synchronized (LockExample.class) {
                    reentrantLock.lock();
                    System.out.println("Acquire " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
//                    }
                    reentrantLock.unlock();
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    reentrantLock.lock();
//                    synchronized (LockExample.class) {
                    System.out.println("Acquire " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
//                    }
                    reentrantLock.unlock();
                }

            }
        });

        thread.start();
        thread2.start();

    }

}
