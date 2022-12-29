package thread;

import org.junit.Test;

import java.util.concurrent.*;

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
    /*
    *
    * 测试线程池
    * */
    @Test
    public void ThreadPool() {
    }

    @Test
    public void demo3() {

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //真正的线程池接口为ExecutorService
        //Executors是线程池的工具类，提供了一些快速创建线程池的api，如创建固定数量的线程池，创建单线程池，创建可伸缩的线程池,但是创建这些线程池都是有耗尽内存的风险，在工作中应使用创建自定义的线程池
        //创建固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //提交一个可执行的任务，参数为Runnable接口的实现类，从线程池中拿一个线程
        //submit方法通常用于获得有返回值的线程任务 如Callable
        //execute方法通常执行无返回值的线程：如Runnable
        Future<String> submit = executorService.submit(new CallableDemo());
        System.out.println(123);
        //主线程阻塞，等待新开辟的子线程完成线程任务
        System.out.println(submit.get());
        System.out.println(456);
        Executors.newSingleThreadExecutor();
        //线程使用结束后并不会死亡，而会重新返回给线程池中，如果不执行shutdown命令，程序不会停止运行
//      executorService.shutdown();
//        MyThreadDemo3 myThreadDemo3 = new MyThreadDemo3();
//        Thread thread1 = new Thread(myThreadDemo3, "窗口1");
//        Thread thread2 = new Thread(myThreadDemo3, "窗口2");
//        Thread thread3= new Thread(myThreadDemo3, "窗口3");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//
//        Thread.sleep(500);
//        System.out.println(myThreadDemo3.getTicket());

    }

}
