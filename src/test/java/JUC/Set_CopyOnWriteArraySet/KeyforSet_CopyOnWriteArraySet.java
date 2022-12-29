package JUC.Set_CopyOnWriteArraySet;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/*
* 解决Set集合线程不安全的方案
* CopyOnWriteArraySet
*
* */
public class KeyforSet_CopyOnWriteArraySet {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i <10000 ; i++) {
            final int temp=i;
            new Thread(()->{
                set.add(temp);
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(set.size());
    }
}
