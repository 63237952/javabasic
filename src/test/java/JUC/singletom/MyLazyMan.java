package JUC.singletom;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/*
* 懒汉式单例:
*   类初始化时，不会初始化单例对象
* */
public class MyLazyMan {

    private MyLazyMan(){
        System.out.println(Thread.currentThread().getName()+"创建了对象");
    };
    public static int B=10;
    private int[] data= new int[100024*1024];
    private int[] data1= new int[1024*1024];
    private int[] data2= new int[1024*1024];
    private int[] data3= new int[1024*1024];
//    private static MyLazyMan lazyMan;
    //在DCL懒汉式的前提下，使用volatile关键字禁止指令重排
    private volatile static MyLazyMan lazyMan;
    //正常的懒汉式单例
    public static MyLazyMan getLazyMan1() {
        if (lazyMan==null){
            lazyMan=new MyLazyMan();
        }
        return lazyMan;
    }
    //DCL模式懒汉式单例
    public static MyLazyMan getLazyMan2() throws InterruptedException {
        if (lazyMan==null){
            synchronized (MyLazyMan.class){
                if (lazyMan==null){
                    Thread.sleep(10);
                    lazyMan=new MyLazyMan();//初始化对象并不是一个原子性操作
                    //1.分配内存空间
                    //2.初始化对象
                    //3.将引用指向内存空间
                    //计算机的指令重排可能会导致执行过程是123或者132
                    //当以132的顺序创建对象时，当3执行完成后，2还未执行，这时cpu开始重新调度线程，别的线程判断                          lazyMan不等于null（前一个线程将引用指向内存空间，但内存空间是一片虚无），执行return返回的是空白
                }
            }
        }
        return lazyMan;
    }



}
