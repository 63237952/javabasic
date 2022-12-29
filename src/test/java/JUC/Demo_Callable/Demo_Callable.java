package JUC.Demo_Callable;

import org.junit.Test;

import java.util.concurrent.*;

/*
* 使用Callable接口创建线程
*1.创建Callable接口的实现类
*2.使用FutureTask包装Callable实现类
*3.将FutureTask对象丢到new Thread（FutureTask）中
*
* Callable与Runnable接口创建多线程的区别
* 1.方式不同
*   Thread初始化时可以直接接收Runnable接口开启多线程
*   Callable需要借助FutureTask对象来包装来开启多线程
* 2.多线程运行的结果不同
*   Runnable接口可以设置线程任务，但是没有返回值
*   Callable接口也可以设置线程任务，但是可以又返回值，Callable接口泛型的类型就是返回值类型
* */
public class Demo_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask,"a").start();
        System.out.println(futureTask.get());
    }
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> result = executorService.submit(myCallable);
        System.out.println(result.get());
    }
}
class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "你好";
    }

}