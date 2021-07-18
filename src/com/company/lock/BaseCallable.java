package com.company.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class BaseCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
//        String product = "prod";
//        String result = null;
//        if (product != null) {
//            result = product + " done";
//        } else {
//            result = "productList is empty";
//        }
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(Thread.currentThread().getName());
        return Thread.currentThread().getName() + " "+System.currentTimeMillis();
    }
}
