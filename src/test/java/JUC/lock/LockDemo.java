package JUC.lock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* Lock是java并发编程常用的显示锁，用于同步线程数据
* ReentrantLock是Lock接口常用的实现类
* ReentrantLock有两种实现模式：
* 1.公平锁：在抢夺锁之前会先判断队列中有没有元素，如果有，则加入到队列的末尾，等待获得锁，线程会按队列的顺序执行
* 2.非公平锁：线程可能在进入链表之前抢占锁，如果抢不到，则也会按照链表的顺序执行
*
* 下面这个测试案例又来测试公平锁和非公平锁的区别
* 整体思路：
* 1.开启20条线程，每隔10毫秒开启一个线程
*      这么做的目的是让各个线程按顺序进入到队列中，如果不设置时间间隔，线程进入队列的顺序是不可控的，很难直接观测结果
* 2.如果是公平锁的话，那么线程执行的顺序也是按照进入队列的顺序执行，结果也确实正是了这一点
* 3.如果是非公平锁的话，那么线程执行的顺序有可能不是按照线程开启的顺序执行，因为线程可能会在进入队列之前，先抢到锁。
* */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        for (int i = 0; i <20; i++) {
            new Thread(() -> {
                bank.print();
            }, i + "线程").start();
            Thread.sleep(10);
        }
    }
}
class Bank{
    private ReentrantLock lock=new ReentrantLock(true);
    public void print(){
        System.out.println(Thread.currentThread().getName());
        lock.lock();
        try {
                /* 必须设置这个线程休眠时间才容易看到结果，这个时间必须大于线程开启的时间间隔，保证有多个线程可以进
               *入到print方法中，而这个时间又不能大于200，因为时间大于200的话所有的线程都已经开启了，并且都调用了
               *lock方法，那么非公平锁可能会插队执行的现象就看不出来了
               */
            Thread.sleep(30);
            Collection<Thread> queue = getQueue();
            System.out.println("当前获得锁正在执行的线程为"+Thread.currentThread().getName()+"---"+"队列中正在排队的线程为:"+queue);

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Collection<Thread> getQueue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getQueuedThreads = lock.getClass().getDeclaredMethod("getQueuedThreads");
        getQueuedThreads.setAccessible(true);
        Collection<Thread> result = (Collection)getQueuedThreads.invoke(lock);
        return result;
    }
}
