package JUC.Demo_Executors;

import java.util.concurrent.*;

/*
* Executors是一个工具类，可以用来创建线程池
* 第一个方法：创建一个固定数量的线程
* 开启线程的方式可以由
* new Thread（（）->{}）.start（）；
* 变为threadPoolService.execute（（）->{}）
*
* */
public class DemoForExecutors {
    public static void main(String[] args) {
/*        Demo1ForExecutors demo1ForExecutors = new Demo1ForExecutors();
        for (int i = 0; i <10 ; i++) {
            ExecutorService threadPoolService = demo1ForExecutors.getThreadPoolService();
            threadPoolService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"正在工作");
            });
        }*/
//=========================================================================================
/*        Demo2ForExecutors demo2ForExecutors = new Demo2ForExecutors();
        ExecutorService threadPoolService = demo2ForExecutors.getSingleThreadPoolService();
        try {
            for (int i = 0; i < 10; i++) {
                threadPoolService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "正在工作");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池使用结束后需要手动关闭
            threadPoolService.shutdown();
        }*/
        Demo3ForExecutors demo3ForExecutors = new Demo3ForExecutors();
        ExecutorService cachedThreadPoolService = demo3ForExecutors.getCachedThreadPoolService();

            try {
                for (int i = 0; i <10000; i++) {
                    cachedThreadPoolService.execute(() -> {
                        System.out.println(Thread.currentThread().getName() + "正在工作");
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //线程池使用结束后需要手动关闭
                cachedThreadPoolService.shutdown();
            }

    }
}
class Demo1ForExecutors{
    //创建一个固定数量的线程池
    private ExecutorService threadPoolService = Executors.newFixedThreadPool(5);

    public ExecutorService getThreadPoolService() {

        return threadPoolService;
    }
}
class Demo2ForExecutors{
    //创建只有单个线程的线程池
    private ExecutorService SingleThreadPoolService = Executors.newSingleThreadExecutor();

    public ExecutorService getSingleThreadPoolService() {
        return SingleThreadPoolService;
    }
}
class Demo3ForExecutors{
    //创建一个线程数可变的线程池
    private ExecutorService cachedThreadPoolService = Executors.newCachedThreadPool();

    public ExecutorService getCachedThreadPoolService() {
        return cachedThreadPoolService;
    }
}