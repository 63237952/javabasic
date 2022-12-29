package JUC.Set_CopyOnWriteArraySet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
* 解决Set集合线程不安全的方案二
* 使用Collections类的同步方法synchronizedSet
* synchronizedSet方法的原理就是给原生的new HashSet<String>()套上了synchronized同步代码块
* */
public class KeyForSet_Collections {

    public static void main(String[] args) throws InterruptedException {
        Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        for (int i = 0; i <100 ; i++) {
            final int temp=i;
            new Thread(()->{
                set.add(String.valueOf(temp));
                System.out.println(set);
            },"").start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(set.size());
    }
}
