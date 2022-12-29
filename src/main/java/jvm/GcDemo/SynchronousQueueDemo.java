package jvm.GcDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {

                System.out.println(Thread.currentThread().getName()+"  put 1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName()+"  put 2");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName()+"  put 3");
                blockingQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        /**
         * 同步队列一次只存放一个元素，每次都要等其他线程把元素取出来才能继续放元素
         * AAA线程在同步队列里面放了元素之后，要等五秒钟以后BBB线程取出元素自后
         * 才能继续往里面放元素，如果没有其他线程来取元素，那么就会产生阻塞
         */

        new Thread(()->{
            try {
                //每五秒钟取一个元素
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()
                        +"  take  "+blockingQueue.take());

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()
                        +"  take "+blockingQueue.take());

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()
                        +"  take  "+blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

    }

}
