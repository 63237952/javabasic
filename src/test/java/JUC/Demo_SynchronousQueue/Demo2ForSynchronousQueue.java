package JUC.Demo_SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

public class Demo2ForSynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue=new SynchronousQueue<Integer>();
        queue.put(1);
        queue.put(12);
    }
}
