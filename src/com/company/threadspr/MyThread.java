package com.company.threadspr;

public class MyThread extends Thread {

    private Result result;

    private int sum = 0;


    public void run() {
        System.out.println("Thread is running");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                if(i == 5)
                    synchronized (Main.result) {
                        Main.result.notifyAll();
                    }
                System.out.println("Mythread " + i);
                sum += i;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mythread sum =  "+sum);
    }

    public int getSum() {
        return sum;
    }
}
