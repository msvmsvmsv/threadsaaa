package com.company.threadspr;

public class MyThread2 extends Thread {

    private boolean isRunning = true;
    private int value;

    public MyThread2(int value) {
        super();
        this.value = value;
    }

    public void finish() {
        isRunning = false;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter != 20) {
//            if (value % 2 == 0)
//                synchronized (Main.result) {
//                    try {
//                        Main.result.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            Main.sum += value;
//            System.out.println(this.getName() + " " + Main.sum);
            counter++;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (value % 2 == 1)
//                synchronized (Main.result) {
//                    Main.result.notify();
//                }
        }
    }
}
