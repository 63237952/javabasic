package JUC.Utils_CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
* 使用wait和notify处理线程通信问题
* 前面的一个类使用了CountDownLatch解决了线程通信
* 需要注意的是这里线程使用的是同一把锁Demo_WaitandNotify.class
* 并且wait和notifyAll是由锁对象发起的
* 如果不是由锁对象发起，则会引发IllegalMonitorStateException非法监视器状态异常
* */
public class Demo_WaitandNotify {
    public static void main(String[] args) {
        //参数代表需要被等待先执行线程数量
        int state=3;
        Worker2 worker = new Worker2(state);
        Product2 product = new Product2(state);
        new Thread(()->{
            worker.work();
        },"工人1号").start();
        new Thread(()->{
            worker.work();
        },"工人2号").start();
        new Thread(()->{
            worker.work();
        },"工人3号").start();
        new Thread(()->{
            product.production();
        },"产品1号").start();
        new Thread(()->{
            product.production();
        },"产品2号").start();
    }
}
class Product2 {
    private int state;

    public Product2(int state) {
        this.state = state;
    }

    public void production() {
        synchronized(Demo_WaitandNotify.class){
        if (state>0){
            try {
                Demo_WaitandNotify.class.wait();
                System.out.println(Thread.currentThread().getName()+"等待生产");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"开启出售");
    }
    }
}
class Worker2 {
    private int state;

    public Worker2(int state) {
        this.state = state;
    }

    public void work() {
        synchronized(Demo_WaitandNotify.class){
        System.out.println(Thread.currentThread().getName()+"正在工作");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state--;
        System.out.println(Thread.currentThread().getName()+"工作结束");
        if (state<=0){
            Demo_WaitandNotify.class.notifyAll();
        }
    }
    }
}