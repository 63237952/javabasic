package thread.Thread_yield;
/*
* 多个线程共同执行的状态下
* 如果想让某个线程暂停下来，使用yield()方法可让当前线程交出cpu的执行权，重新开启新一轮的cpu调度
*
*
* */
public class Thread_yield implements Runnable {


    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行");
        //暂停当前任务，进入Runable状态
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }

    //程序入口
    public static void main(String[] args) {
        Thread_yield threadYield = new Thread_yield();
        //开启a，b俩个线程
        new Thread(threadYield,"a").start();
        new Thread(threadYield,"b").start();
    }
}
