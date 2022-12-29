package JUC.Map_ConcurrentHashMap;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/*
*
* HashMap集合的特点
* 以键值对的方式存放数据
* key不可重复
*
* 多线程环境下线程不安全
* */
public class Demo1_HashMap {
    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <1000 ; i++) {
            final int temp=i;
            new Thread(()->{
                hashMap.put(String.valueOf(temp),temp);
            },i+"").start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(hashMap.size());
    }
}
