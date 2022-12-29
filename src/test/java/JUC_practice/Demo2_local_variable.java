package JUC_practice;

import java.util.concurrent.Executors;

public class Demo2_local_variable {
    private static int i=0;
    public static void main(String[] args) throws InterruptedException {

        Executors.newFixedThreadPool(5).submit(()->{
            try {
                m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Executors.newFixedThreadPool(5).submit(()->{
            try {
                m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.currentThread().sleep(5000);
        System.out.println(Demo2_local_variable.i);
    }

    public static void m1() throws InterruptedException {
        for (int j = 0; j <100 ; j++) {
            i++;
            Thread.sleep(3);
        }
    }
}
