package JUC.Demo_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 *BlockingQueue接口第四组操作元素的api
 * offer(E e, long timeout, TimeUnit unit)/poll(long timeout, TimeUnit unit)
 *          不会抛出异常，存元素时，如果队列满了，线程会阻塞等待,超时过后，添加失败
 *                        取元素时，如果队列为空，线程也会阻塞等待，超时过后，取出为null
 * */
public class Demo4ForBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        //存元素
        System.out.println(queue.offer(1, 1, TimeUnit.SECONDS));
        System.out.println(queue.offer(2, 1, TimeUnit.SECONDS));
        System.out.println(queue.offer(3, 1, TimeUnit.SECONDS));
        //队列阻塞，如果等待时间超过一秒，添加失败
        System.out.println(queue.offer(4, 1, TimeUnit.SECONDS));

        //取元素
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        //超时等待，时间到了之后，取出的值为null
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
    }
}
