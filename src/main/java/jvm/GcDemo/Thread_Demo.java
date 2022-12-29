package jvm.GcDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_Demo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <10; i++) {
            executorService.execute(()->{
                byte[] bytes = new byte[1024 * 1024 * 5];
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
