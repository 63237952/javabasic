package thread_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/*
*Volatile不保证原子性操作测试
* ----------------------------
* Volatile关键字修饰的成员变量
* 不保证原子性
* 原子性:一个操作要么同时成功，要么同时失败，在多线程程序中，有多个线程同时对他操作时
* 有可能成功，有可能失败
* 例如有多个线程同时对他进行写操作时，并不是像加了sychonized关键字一样，同时只能有一个线程进行操作
* 多个线程可能同时对它进行了写操作，无法保证原子性
*
* 测试原理
* 开启1000个线程并发对成员变量a进行写操作（+1）
* 如果这个写操作具备原子性
* 则最终输出的a为1000
* 如果不具有原子性
* 则输出结果小于1000
*
* */
public class Volatile_Demo2 {
    //成员变量a使用关键字Volatile
    private static volatile AtomicInteger a=new AtomicInteger(0);

    private static void add(){
        //该写操作不是不具备原子性的
//        a++;
        a.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    add();
                }
            }).start();
        }
        System.out.println(a);
    }
}
//控制台输出结果为998，表明了Volatile关系字修饰的成员变量de写操作不具有原子性特征