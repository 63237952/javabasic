package JUC.synchronized_8lock;

import java.util.concurrent.TimeUnit;

/**
 * 3.增加一个普通方法,是先执行发短信还是hello（2秒钟输出hello，3秒后输出发短信,最后打电话）
 * 4.两个对象，两个同步方法，先打电话，再发短信（两个不同的对象，两把锁）
 */
public class Demo2_synchronized {
    public static void main(String[] args) throws InterruptedException {
        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(()->{
            phone.sendMessage();
        },"a").start();
        //休息1秒，保证发短信的线程先开启
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            phone2.call();
        },"b").start();
//        TimeUnit.SECONDS.sleep(1);
//        new Thread(()->{
//            phone.hello();
//        },"b").start();
    }
}
class Phone2{
    public synchronized void sendMessage()  {
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
    //这里没有锁,不是同步方法,不受锁的影响
    public void hello() {
        System.out.println("hello");
    }
}