package JUC.Demo_Semophore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
*Semaphore在多线程环境下常用到的辅助类，用于限制线程的执行数量
* 例如在一个项目中可以开启很多个线程，这些线程被cpu调度到的机会是随机的，如果线程很多的话
* 可能有些线程需要等待很久才会执行完成
* 如果使用了Semaphore来控制线程执行的数量的话，就会提高这些线程被调度到机会
* 举例：汽车到车库停车
* 如果把多个线程比作多辆汽车
* 那么Semaphore就如同车库
* 车库的数量是有限的，只有抢到车位的汽车才能停车，抢不到车位的汽车只能等待，车位空出来
*
* */
public class DemoForSemaPhore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("汽车"+Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println("汽车"+Thread.currentThread().getName()+"离开");
                }
            },String.valueOf(i)).start();
        }
    }
}
