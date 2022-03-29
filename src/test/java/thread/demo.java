package thread;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class demo {
    /*
    * 使用Threa子类来创建多线程*/
    @Test
    public  void demo1() {

        MyThread myThread = new MyThread("新线程");
        //myThread.name //父类的属性是私有的，无法直接获取；
        //开启子线程
        myThread.start();
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
    /*
    * 使用实现Runable接口的方式来创建多线程
    * */
    @Test
    public  void demo2() {
        MyRunableImpl myRunable = new MyRunableImpl();

        Thread thread1 = new Thread(myRunable, "thread1");
        //开启第一个线程
        thread1.start();
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }

    @Test
    public static void main(String[] args) {
//        MyThreadDemo3 myThreadDemo3 = new MyThreadDemo3();
//        Thread thread1 = new Thread(myThreadDemo3, "窗口1");
//        Thread thread2 = new Thread(myThreadDemo3, "窗口2");
//        Thread thread3= new Thread(myThreadDemo3, "窗口3");
//        thread1.start();
//        thread2.start();
//        thread3.start();
        //Executors类中定义了创建一个有固定数量线程池对象的方法
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new ThreadPool());
        //线程使用结束后并不会死亡，而会重新返回给线程池中，如果不执行shutdown命令，程序不会停止运行
        executorService.shutdown();
    }

    @Test
    public void demo3() {

    }


}
