package thread.Thread_synchronized;

import java.util.ArrayList;
import java.util.List;
/*
* ArrayList不是线程安全的，它作为共享数据进行操作时，存在线程安全问题
*对run方法加锁解决
* 每次只有一个线程对list进行操作
*
* 解决ArrayList()高并发情况下线程不安全的方案有三种
* 有待验证与探讨
* vector 在add方法上加上synchronized锁
* Collections的静态方法synchronizedList(List< T> list)
* copyonwritearraylist写时复制的思想
* */
public class ArrayList_unsafe implements Runnable {
    private static List list=new ArrayList();
    public  void run() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList_unsafe arrayList_unsafe = new ArrayList_unsafe();
        for (int i = 0; i <100 ; i++) {
            Thread thread = new Thread(arrayList_unsafe,"thread--"+i);
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
