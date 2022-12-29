package JUC.Utils_CountDownLatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
* CountDownLatch在多线程环境下的常用工具类
* 允许一个线程或者多个线程去等待其他线程完成任务
*
* 案例:
* 开启了5个线程，3个工人线程，2个产品线程
* 这5个线程工作的逻辑是，工人线程先开始工作
* 工人线程工作完毕后，产品线程才开始工作
*
* 使用了CountDownLatch来控制线程执行的先后顺序
* */
public class Demo_CountDownLatch {
    public static void main(String[] args) {
        //参数代表需要被等待先执行线程数量
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Worker worker = new Worker(countDownLatch);
        Product product = new Product(countDownLatch);
        new Thread(()->{
            worker.work();
        },"工人1号").start();
        new Thread(()->{
            worker.work();
        },"工人2号").start();
        new Thread(()->{
            worker.work();
        },"工人3号").start();
        new Thread(()->{
            product.production();
        },"产品1号").start();
        new Thread(()->{
            product.production();
        },"产品2号").start();
    }
}
class Product {
    private CountDownLatch latch;

    public Product(CountDownLatch latch) {
        this.latch = latch;
    }


    public void production() {
        try {
            latch.await();
            System.out.println(Thread.currentThread().getName()+"等待生产");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"开启出售");
    }
}
class Worker {
    private CountDownLatch latch;
    public Worker(CountDownLatch countDownLatch){
        this.latch=countDownLatch;
    }


    public void work() {
        System.out.println(Thread.currentThread().getName()+"正在工作");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"工作结束");
        latch.countDown();

    }
}