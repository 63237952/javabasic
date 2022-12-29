package thread.Thread_priority;
/*
* 多线程的环境下
* 可以通过设置线程优先级
* 优先级高的线程 被cpu优先调度的概率高
* Thread类中提供了一个int类型成员变量priority，来代表线程的优先级
* private int priority
* 可以通过setPriority来设置线程的优先级（1-10）例如Thread.setPriority(1)
* 默认线程的优先级是5，最小的优先级是1，最大的优先级是10
* */
public class ThreadPriority implements Runnable{


    public void run() {
        System.out.println(Thread.currentThread().getName()+"----"+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        ThreadPriority threadPriority = new ThreadPriority();
        Thread thread1 = new Thread(threadPriority, "线程1");
        Thread thread2 = new Thread(threadPriority, "线程2");
        Thread thread3 = new Thread(threadPriority, "线程3");
        //设置线程1的优先级为1
        thread1.setPriority(1);
        thread1.start();
        //默认线程2的优先级为5
        thread2.start();
        //设置线程3的优先级为10
        thread3.setPriority(10);

        thread3.start();

        //预计的线程执行顺序为线程3--》线程2--》线程1
    }

}
