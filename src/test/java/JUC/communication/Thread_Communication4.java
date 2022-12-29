package JUC.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_Communication4 {
    public static void main(String[] args) {
        ProductIV product = new ProductIV();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.production1();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者a").start();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.production2();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者b").start();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.consumption1();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者c").start();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.consumption2();
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
class ProductIV{
    private int product=0;
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();
    private Condition condition4=lock.newCondition();
    //生产方法
    public  void production1() throws InterruptedException {
        lock.lock();
        try {
            while (product!=0){
                condition1.await();
            }
            product++;
            System.out.println(Thread.currentThread().getName()+":"+"产品数量为"+product+"通知消费者线程");
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //消费方法
    public  void consumption1() throws InterruptedException {
        lock.lock();
        try {
            while (product==0){
                condition2.await();
            }
            product--;
            System.out.println(Thread.currentThread().getName()+":"+"产品数量为"+product+"通知生产者线程");
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public  void production2() throws InterruptedException {
        lock.lock();
        try {
            while (product!=0){
                condition3.await();
            }
            product++;
            System.out.println(Thread.currentThread().getName()+":"+"产品数量为"+product+"通知消费者线程");
            condition4.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //消费方法
    public  void consumption2() throws InterruptedException {
        lock.lock();
        try {
            while (product==0){
                condition4.await();
            }
            product--;
            System.out.println(Thread.currentThread().getName()+":"+"产品数量为"+product+"通知生产者线程");
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}