package JUC.synchronized_8lock;


import java.util.concurrent.TimeUnit;

/*
* 8锁现象，彻底理解synchronized锁的对象是谁
* 发短信线程先开启，打电话线程后开启
* 1.标准情况下是先发短信还是打电话 先发短信，后打电话（发短信线程先抢占到锁）
* 2.发短信方法延迟2秒 先发短信，后打电话（两个线程竞争同一把锁，发短信先拿到了，并且sleep方法不会释放锁）
*
* */
public class Demo1_synchronized {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMessage();
        },"a").start();
        //休息1秒，保证发短信的线程先开启
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            phone.call();
        },"b").start();
    }
}
class Phone{
    public synchronized void sendMessage()  {
        //发短信休息两秒，保证打电话的进程启动起来后跟发短信的线程竞争锁
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}