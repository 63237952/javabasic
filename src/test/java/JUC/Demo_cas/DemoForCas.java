package JUC.Demo_cas;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
* CAS的概念：比较并交换,比较工作内存和主内存中的值，如果是预期的就更新，不是预期的值就自旋
* CompareAndSet
* */
public class DemoForCas {
    private static final AtomicInteger a=new AtomicInteger(100);
    private static int b=100;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <100000 ; i++) {
            new Thread(()->{
                //原子性操作，多线程操作下，不会发生线程安全问题，底层使用的就是cas
                System.out.println(a.getAndIncrement());
                //非原子性操作，存在线程安全问题
//                b+=1;
            },i+"").start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(a);
    }
}
