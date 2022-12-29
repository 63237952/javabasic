package JUC.Demo_SynchronousQueue;


//import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.concurrent.SynchronousQueue;

/*
* 同步队列SynchronousQueue，队列的容量为1，每次存一个元素之后，必须等待取出第二个元素才能接着存入
* */
public class DemoForSynchronousQueue {
    public static void main(String[] args) {
        MySynchronousQueue mySynchronousQueue = new MySynchronousQueue();
        for (int i = 0; i <3 ; i++) {
            final int temp=i;
            new Thread(()->{
                try {
//                    Thread.sleep(1000);
                    mySynchronousQueue.put(temp);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"存元素线程"+i).start();
        }
        for (int i = 0; i <3 ; i++) {
            final int temp=i;
            new Thread(()->{
                try {
//                    Thread.sleep(10000);
                    mySynchronousQueue.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"取元素线程"+i).start();
        }
    }
}
class MySynchronousQueue{
    private SynchronousQueue queue=new SynchronousQueue<Integer>();
    public void put(Integer integer) throws InterruptedException {
        queue.put(integer);
        System.out.println(Thread.currentThread().getName()+"存入元素成功");
    }
    public void get() throws InterruptedException {
        Integer integer = (Integer)queue.take();
        System.out.println(Thread.currentThread().getName()+"取出元素成功"+integer);
    }
}
