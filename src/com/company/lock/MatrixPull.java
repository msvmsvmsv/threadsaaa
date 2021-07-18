package com.company.lock;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixPull {

    static int size = 30;
//    static int[][] matrix = new int[size][size];

    public static void main(String[] args) throws InterruptedException {

        int[][] matrix = new int[size][size];
        int[][] matrix2 = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(100);
                matrix2[i][j] = random.nextInt(100);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(matrix2));


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < size; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < size; j++) {
//                        System.out.println(Thread.currentThread().getName() +" "+finalI);
                        matrix[finalI][j] += matrix2[finalI][j];
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.MINUTES);
        System.out.println(Arrays.deepToString(matrix));

    }
}
