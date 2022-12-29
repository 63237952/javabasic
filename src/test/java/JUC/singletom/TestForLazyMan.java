package JUC.singletom;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestForLazyMan{
    //模拟类加载时，不会初始化单例对象
    @Test
    public void Tests1() {
        //当使用类名.B拿到该类的类变量时，加载了类TestLazyMan，但不会初始化对象
        int b = MyLazyMan.B;
    }
    //在多线程下，懒汉式单例并非线程安全的，如果开启多个线程去获得对该对象，但是，对象还未被初始化，就会在内存中
    //创建多个对象，原因是该模式下单例，并非线程安全的
    //测试中由于创建了多个对象，导致内存溢出异常（oom）
    @Test
    public void Tests2() {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                MyLazyMan lazyMan = MyLazyMan.getLazyMan1();
                System.out.println(lazyMan);
            },i+"").start();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //测试使用volatile关键字修饰DCL懒汉式单例，不会出现线程安全的请情况，可以禁止指令重排导致的返回空白
        //指令重排现象无法测出来，但理论上存在
//        for (int i = 0; i <10 ; i++) {
//            new Thread(()->{
//                MyLazyMan lazyMan = null;
//                try {
//                    lazyMan = MyLazyMan.getLazyMan2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(lazyMan);
//            },i+"").start();
//        }

        //使用反射可以破坏DCL懒汉式单例,内存中存在了两个对象
        Class<MyLazyMan> myLazyManClass = MyLazyMan.class;
        Constructor<MyLazyMan> declaredConstructor = myLazyManClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        MyLazyMan myLazyMan = declaredConstructor.newInstance();
        MyLazyMan myLazyMan1 = declaredConstructor.newInstance();
        System.out.println(myLazyMan);
        System.out.println(myLazyMan1);
    }
}