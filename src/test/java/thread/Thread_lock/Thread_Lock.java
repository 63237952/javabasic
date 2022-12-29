package thread.Thread_lock;

import java.util.concurrent.locks.ReentrantLock;

/*
* 线程数据同步，除了使用synchronized关键字，隐式的加锁外
* jdk中还提供了一个Lock对象可以显示的加锁，实现线程同步
* Lock对象是一个接口，一般使用ReentrantLock来创建锁
*
* */
public class Thread_Lock implements Runnable {
    //定义锁对象l
   private final ReentrantLock lock=new ReentrantLock();
   private int ticket=10;
   private Object O=new Object();
    public  void run() {
        while(true){
            try {
                lock.lock();
                if (ticket>0) {
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket--+"张票");

                }else {
                    break;
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
         }
    }

    public static void main(String[] args) {
        Thread_Lock thread_lock = new Thread_Lock();
        new Thread(thread_lock,"窗口1").start();
        new Thread(thread_lock,"窗口2").start();
        new Thread(thread_lock,"窗口3").start();

    }
}
