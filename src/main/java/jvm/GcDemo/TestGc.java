package jvm.GcDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
* 垃圾回收线程触发的时机：
* 1.new新对象时，伊甸园区放不下，触发一次垃圾回收，将存活的对象放入幸存区
* 如果幸存区的空间不足，则将剩余的存货对象放入到老年代中，如果老年代也放不下就会触发full GC，如果full后老年代空间仍不足，
* 就会出现out of Memory异常
*
* 伊甸园区内存紧张时，进行垃圾回收
*
* */
public class TestGc {
    private static final int _512k=512*1024;
    private static final int _1M=1024*1024;
    private static final int _5M =1024 * 1024 * 5;
    private static final int _7M=1024*1024*7;
    private static final int _8M=1024*1024*8;
    //-Xms20m -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc虚拟机参数
    public static void main(String[] args) throws IOException, InterruptedException {
        List<byte[]> list=new ArrayList<>();
        list.add(new byte[_1M]);
        list.add(new byte[_5M]);
        list.add(new byte[_5M]);
        list.add(new byte[_5M]);
//        System.in.read();
//        Thread.sleep(3000);
    }
}
