package JUC.Map_ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
/*
* 解决HashMap多线程环境的线程安全问题方案
* 使用java并发包下的ConcurrentHashMap类
*
* */
public class KeyForHashMap_ConcurrentHashMap {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<String, Integer>();
        for (int i = 0; i <10000 ; i++) {
            final int temp=i;
            new Thread(()->{
                hashMap.put(String.valueOf(temp),temp);
            },i+"").start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(hashMap.size());
    }
}
