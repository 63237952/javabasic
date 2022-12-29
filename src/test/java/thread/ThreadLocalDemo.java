package thread;

import java.lang.reflect.Field;

public class ThreadLocalDemo {
          Integer a=100;
         ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
         public void init(){
             threadLocal.set(100);
         }
    public static void main(String[] args) throws NoSuchFieldException {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
            threadLocalDemo.init();
        new Thread(()->{
            Integer a1 = threadLocalDemo.threadLocal.get();
//            a1=1000;
            System.out.println(Thread.currentThread().getName()+a1);
        },"a").start();
        new Thread(()->{
            Integer a1 = threadLocalDemo.threadLocal.get();
//            a1=10000;
            System.out.println(Thread.currentThread().getName()+a1);
        },"b").start();
        System.out.println(Thread.currentThread().getName()+threadLocalDemo.threadLocal.get());
    }
}
