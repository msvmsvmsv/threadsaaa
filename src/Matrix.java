import java.util.Arrays;
import java.util.Random;

public class Matrix {
    static int size = 5;
    static int[][] matrix = new int[size][size];

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

        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < size; j++) {
                        System.out.println(Thread.currentThread().getName() +" "+finalI);
                        matrix[finalI][j] += matrix2[finalI][j];
                    }
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < size; i++) {
            threads[i].join();
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
