package JUC.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 使用ReentrantLock解决消费者和生产者问题
*
*
* */
public class Thread_Communication3 {
    public static void main(String[] args) {
        ProductIII product = new ProductIII();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.production();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者a").start();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.production();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者b").start();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.consumption();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者c").start();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.consumption();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者d").start();
    }
}
/*
* 使用condition对象实现精准唤醒
* new 多个condition对象
* 使用condition对象的signal方法
* */
class ProductIII{
    private int product=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    //生产方法
    public  void production() throws InterruptedException {
        lock.lock();
        try {
            while (product!=0){
                condition.await();
            }
            product++;
            System.out.println(Thread.currentThread().getName()+":"+"产品数量为"+product+"通知消费者线程");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //消费方法
    public  void consumption() throws InterruptedException {
        lock.lock();
        try {
            while (product==0){
                condition.await();
            }
            product--;
            System.out.println(Thread.currentThread().getName()+":"+"产品数量为"+product+"通知生产者线程");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}