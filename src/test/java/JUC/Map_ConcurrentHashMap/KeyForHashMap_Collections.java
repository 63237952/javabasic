package JUC.Map_ConcurrentHashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/*
* 解决HashMap线程不安全问题的方案二
* 使用Collections的SynchronizedMap方法
* 原理也是在new HashMap<String, Integer>()原生的map集合的方法套在同步代码块中
* */
public class KeyForHashMap_Collections {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> hashMap = Collections.synchronizedMap(new HashMap<String, Integer>());
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
