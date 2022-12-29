package thread.Thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 线程池技术:预先创建多个线程放在一个容器，每次需要使用时，就从容器中拿线程，线程使用完就归还到池中。
* 好处：不用频繁的创建和销毁线程，节省系统资源
* 使用工具类来创建线程池：Executors
* 线程池接口：ExecutorService
*       方法：execute
* */
public class Thread_pool implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread_pool thread_pool = new Thread_pool();
        //创建一个固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(thread_pool);
        executorService.execute(thread_pool);
        executorService.execute(thread_pool);
        executorService.execute(thread_pool);
        //关闭线程池，如果不关闭，程序不会停止
        executorService.shutdown();
    }
}
