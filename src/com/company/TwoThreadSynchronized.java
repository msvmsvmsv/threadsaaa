package com.company;

public class TwoThreadSynchronized {
    public static int counter = 0;
    final static StringBuilder s = new StringBuilder();

    public synchronized  void method(){
        while (TwoThreadSynchronized.counter++ < 6) {
            s.append("B");
            System.out.println(s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }

    public synchronized void method2(){
        do {
            s.append("A");
            System.out.println(s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        } while (TwoThreadSynchronized.counter++ < 2);
    }

    public static void main(String args[]) {

        new Thread() {
            public void run() {
                System.out.println("T1");
//                method();
            }
        }.start();
        new Thread() {
            public void run() {
                System.out.println("T2");
//               method2();
            }
        }.start();

    }
}
