package collection;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> integers = new LinkedBlockingQueue<>();
        integers.offer(1);
        integers.offer(2);
        integers.offer(3);
    }
}
