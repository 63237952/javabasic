package JUC.Demo_ThreadPoolExecutor;

import java.util.concurrent.*;

/*
* 自定义线程池：使用ThreadPoolExecutor类
* 也是阿里巴巴规范手册中推荐的方法
* ThreadPoolExecutor包含七大参数
*
* int corePoolSize,核心线程数
* int maximumPoolSize,最大线程数
* long keepAliveTime,存活时间
* TimeUnit unit,时间单位
* BlockingQueue<Runnable> workQueue，阻塞队列
* ThreadFactory threadFactory，线程工厂
* RejectedExecutionHandler handler，拒绝策略
* */
public class DemoForThreadPoolExecutor {
    public static void main(String[] args) {
        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1,//超时了没人用就会释放
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()//银行满了还有人进来，不处理这个人，抛出异常
//                  new ThreadPoolExecutor.DiscardPolicy()//队列满了不会抛出异常，丢掉任务
                new ThreadPoolExecutor.CallerRunsPolicy()//哪里来的去哪里，多余的线程任务在调用线程的方法中执行
//                new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了，尝试去和最早得竞争，也不会抛出异常
        );
        /*
        * 问题一:什么情况下会触发最大线程数
        * 答：当运行的线程数>队列+核心线程数时触发
        *
        * */
        //当i>10时触发最大线程数量
        //运行的线程最大的承载量=最大线程数+队列=10+5=15
        try {
            for (int i = 0; i < 20; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
