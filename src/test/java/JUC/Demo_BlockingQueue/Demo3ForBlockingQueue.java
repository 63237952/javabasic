package JUC.Demo_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/*
 *BlockingQueue接口第三组操作元素的api
 * put/take 不会抛出异常，存元素时，如果队列满了，线程会阻塞等待
 *                        取元素时，如果队列为空，线程也会阻塞等待
 * */
public class Demo3ForBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        //示例1，存元素时，如果队列已满，线程将会阻塞
        queue.put(1);
        queue.put(2);
        queue.put(3);
        //队列已满，线程运行到这里阻塞了
        queue.put(4);
        System.out.println("main1线程运行结束");
        //示例2，取元素时，如果队列为空，线程将会阻塞
        /*
        queue.put(1);
        queue.put(2);
        queue.put(3);

        queue.take();
        queue.take();
        queue.take();
        //队列为空线程阻塞
        queue.take();
        System.out.println("main线程运行结束");*/
    }
}
