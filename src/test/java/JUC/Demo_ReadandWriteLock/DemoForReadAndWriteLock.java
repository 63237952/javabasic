package JUC.Demo_ReadandWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* 可重入读写锁
* 对于共享数据的操作可以分为：读操作和写操作
* 读数据时，有多个线程并发操作并不会引起数据的安全问题，写数据时才要求必须是线程同步的
* 之前使用了ReentrantLock提供显示的加锁并没有对读写操作并没有区分，只要是加了锁就是原子性操作。
*
* JUC包下提供了一个ReentrantReadAndWriteLock
* 可以分别给读写数据加锁，读数据时加的是读锁，写数据时加的是写锁
* 这样一来读数据时可以并发进行，写数据时原子性操作
* 总结该锁的特点是：
* 读-读：可以并发操作
* 读-写:不可以并发操作
* 写-写：不可以并发操作
* */
public class DemoForReadAndWriteLock {
    public static void main(String[] args) {
        Mycatch mycatch = new Mycatch();
        for (int i = 0; i <10 ; i++) {
            final int temp=i;
            new Thread(()->{
                mycatch.putData(String.valueOf(temp),temp);

            },"写线程"+i+"号").start();
        }
        for (int i = 0; i <10 ; i++) {
            final int temp=i;
            new Thread(()->{
                Integer data = mycatch.getData(String.valueOf(temp));
                System.out.println(Thread.currentThread().getName()+"读取数据成功:"+data);
            },"读线程"+i+"号").start();
        }
    }
}
class Mycatch{
    private Map<String,Integer> map=new HashMap<String,Integer>();
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public void putData(String str,Integer in){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+":准备写入数据");
            map.put(str,in);
            System.out.println(Thread.currentThread().getName()+":写入数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
    public Integer getData(String str) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"准备读取数据成功");
            return map.get(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return  null;
    }

}