package JUC.Demo_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/*
*BlockingQueue接口第二组操作元素的api
* offer/poll 不会抛出异常，存元素时，如果队列满了，会添加失败
*                          取元素时，如果队列为空，则取出的元素为null
*
* */
public class Demo2ForBlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
        System.out.println(queue.offer(4));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
