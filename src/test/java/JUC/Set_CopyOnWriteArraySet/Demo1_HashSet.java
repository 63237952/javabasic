package JUC.Set_CopyOnWriteArraySet;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/*
*
* Set集合的特点
* 无序的集合
* 不可存放重复的元素
*高并发情况下线程不安全
* */
public class Demo1_HashSet {
    public static void main(String[] args) throws InterruptedException {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <1000 ; i++) {
            final int temp=i;
            new Thread(()->{
                set.add(temp);
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(set.size());
    }
}
