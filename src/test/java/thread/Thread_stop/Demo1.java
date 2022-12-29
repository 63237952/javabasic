package thread.Thread_stop;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 测试使用标志位停止当前的线程
* 设置一个标志位flag
* run方法中使用while循环对该标志位进行判断
* 如果为true就执行，如果为false就终止当前的线程
* 设置一个方法stop强制改变该标志位，停止线程
*
* */
public class Demo1 implements Runnable {
    private boolean flag=true;
    public void run() {
        int i=0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+i++);
        }
    }
    public void stop(){
        flag=false;
    }

    public static void main(String[] args) {
//        Date date2 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date2));
        Demo1 demo1 = new Demo1();
        new Thread(demo1,"子线程").start();
        //main线程休眠5秒钟后，终止子线程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo1.stop();
    }
}
