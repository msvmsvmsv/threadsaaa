package com.company.lock;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExampleMain {
    public static void main(String[] args) {
        ArrayList<Future<String>> list = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 7; i++) {
            list.add(es.submit(new BaseCallable()));
        }
        es.shutdown();
        for (Future<String> future : list) {
            try {
                System.out.println(future.get() + " result fixed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
