package JUC.Demo_CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
* 多线程常用辅助类CyclicBarrier
* 可以简单理解为加法计数器
*  初始化CyclicBarrier对象时，给定等待的线程数量，及传入Runnable实现类CyclicBarrier(int n, Runnable r)
*  当CyclicBarrier.await()执行了n次后，r开使执行run方法
* */
public class DemoForCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("7个线程已完成任务，开始输出");
        });

        for (int i = 0; i <7 ; i++) {
            new Thread(()->{
                System.out.println("线程"+Thread.currentThread().getName()+"完成任务");
                try {
                    //执行一次await方法，就是+1操作
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
