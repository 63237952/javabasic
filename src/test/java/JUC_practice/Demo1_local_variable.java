package JUC_practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 局部变量也不一定是线程安全的案例
* StringBuilder是线程不安全的，多个线程同时操作，存在线程安全问题
* */
public class Demo1_local_variable {

    public static void main(String[] args) {
//        StringBuilder stringBuilder = Demo1_local_variable.m3();
//        //创建了一个固定数量的线程池
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            executorService.submit(()->{
                m2(stringBuilder);
            });
        }
    }
    //StringBuilder作为局部变量，是线程安全的
    public static void m1(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(2);
        stringBuilder.append(3);
        System.out.println(stringBuilder);
    }
    //StringBuilder 作为方法参数，它并不是线程私有的，所以存在线程安全问题
    public static void m2(StringBuilder stringBuilder){
        stringBuilder.append(4);
        stringBuilder.append(5);
        stringBuilder.append(6);
        System.out.println(stringBuilder+Thread.currentThread().getName());
    }
    //StringBuilder虽然是局部变量，但是它的引用作为返回值返回了，在多线程的环境下，可能同时存在多个线程对该引用进行操作
    public static StringBuilder m3(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(7);
        stringBuilder.append(8);
        stringBuilder.append(9);
        System.out.println(stringBuilder);
        return stringBuilder;
    }
}
