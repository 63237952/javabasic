package JUC.synchronized_8lock;

import java.util.concurrent.TimeUnit;
/*
* 5.两个静态同步方法，先发短信还是先打电话？（先发短信，后打电话）
* 6.两个对象，两个静态同步方法，先发短信还是先打电话？（先发短信，后打电话）
* */
public class Demo3_synchronized {
    public static void main(String[] args) throws InterruptedException {
        Phone3 phone = new Phone3();
        Phone3 phone2 = new Phone3();
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
class Phone3{
    public static synchronized void sendMessage()  {
        //发短信休息两秒，保证打电话的进程启动起来后跟发短信的线程竞争锁
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }
}