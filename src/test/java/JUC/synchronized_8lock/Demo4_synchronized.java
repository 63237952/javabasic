package JUC.synchronized_8lock;

import java.util.concurrent.TimeUnit;
/*
* 一个对象，一个静态同步方法，一个普通同步方法，先打电话还是先发短信？(先打电话，因为不是同一把锁)
* 两个个对象，一个静态同步方法，一个普通同步方法，先打电话还是先发短信？（先打电话，因为不是同一把锁）
* */
public class Demo4_synchronized {
    public static void main(String[] args) throws InterruptedException {
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();
        new Thread(()->{
            phone.sendMessage();
        },"a").start();
        //休息1秒，保证发短信的线程先开启
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            phone2.call();
        },"b").start();
    }
}
class Phone4{
    public static synchronized void sendMessage()  {
        //发短信休息两秒，保证打电话的进程启动起来后跟发短信的线程竞争锁
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}