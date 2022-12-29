package thread_test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HanderPolicy {
    public static void main(String[] args) {
        //创建线程池，并获得线程池管理对象
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.CallerRunsPolicy());

        //使用Runnable的lambda表达式实现任务提交
        threadPoolExecutor.submit(()-> {

            System.out.println(Thread.currentThread().getName()+"执行了");
            //线程内部的线程池
            ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.CallerRunsPolicy());

            for (int i=1;i<=20;i++) {
//                int j=i;

                threadPoolExecutor1.submit(()->
                {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"执行了");
                });
            }
        });
            }
}