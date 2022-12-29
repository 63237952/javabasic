package jvm.GcDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
* 测试Lock接口常用的接口功能
* tryLock
* */
public class ReentrantLock_Demo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 5l, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i <3 ; i++) {
            threadPool.execute(()->{
                try {
                    if (lock.tryLock(1,TimeUnit.SECONDS)){
                        System.out.println(Thread.currentThread().getName()+"获得锁"+lock.getHoldCount());
                        Thread.sleep(3000);
                    }else{
                        System.out.println(Thread.currentThread().getName()+"线程执行其他操作，不用等待加锁的过程");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //为什么要加上该判断，因为前面的逻辑中，没获得锁的线程也会走unlock的过程，会报IllegalMonitorStateException
                    if(lock.isHeldByCurrentThread()){
                        lock.unlock();
                        System.out.println(Thread.currentThread().getName()+lock.isHeldByCurrentThread());
                    }

                }
            });
        }
    }


}
