package jvm.GcDemo;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 场景说明：使用Lock接口显示的加锁和解锁来实现线程安全
* 与synchronized相比，Lock接口在线程竞争激烈下的效率更高
*测试结果：线程的竞争不激烈的时候与否二者的效率差不多，甚至synchronized要优于lock锁
* */
public class Lock_Demo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Ticket ticket = new Ticket();
        Thread[] threads = new Thread[1000000];
        long start = System.currentTimeMillis();
        for (int i = 0; i <threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    lock.lock();
                    ticket.saleTicket();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].start();
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].join();
        }
        long end = System.currentTimeMillis();
        System.out.println("lock"+(end-start));
    }
    @Test
    public void test1() throws InterruptedException {
        Ticket ticket = new Ticket();
        Thread[] threads = new Thread[1000000];
        long start = System.currentTimeMillis();
        for (int i = 0; i <threads.length; i++) {
            threads[i] = new Thread(()->{

                synchronized (ticket) {
                    try {
                        ticket.saleTicket();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].start();
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].join();
        }
        long end = System.currentTimeMillis();
        System.out.println("synch"+(end-start));
    }
}
class Ticket{
    public boolean flag=true;
    public int a=0;
    public long end;
    public void saleTicket() throws InterruptedException {
        if(true){
            System.out.println(Thread.currentThread().getName()+"正在卖第"+"张票"+a++);
        }
    }
}
/*public class Lock_Demo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Ticket ticket = new Ticket();
        Thread[] threads = new Thread[100010];
        long start = System.currentTimeMillis();
        for (int i = 0; i <threads.length; i++) {
            threads[i] = new Thread(() -> {
//                while (ticket.flag) {
                if(ticket.ticket>0) {
                    try {
                        lock.lock();
                        ticket.saleTicket();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
//                }
            });
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].start();
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].join();
        }
        System.out.println("lock"+(ticket.end-start));
    }
    @Test
    public void test1() throws InterruptedException {
        Ticket ticket = new Ticket();
        Thread[] threads = new Thread[100010];
        long start = System.currentTimeMillis();;
        for (int i = 0; i <threads.length; i++) {
            threads[i] = new Thread(()->{
//                while(ticket.flag) {
                if(ticket.ticket>0){
                synchronized (ticket) {
                    try {
                        ticket.saleTicket();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
//                }
            });
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].start();
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].join();
        }

        System.out.println("synch"+(ticket.end-start));
    }

}
class Ticket{
    public int ticket=100000;
    public boolean flag=true;
    public long end;
    public void saleTicket() throws InterruptedException {
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket--+"张票");
        }
        else {
            if (flag==false){
                return;
            }
            end = System.currentTimeMillis();
            flag=false;
        }
    }
}*/
//比较synchronized和lock的效率，开辟线程使用线程池的方式
/*
public class Lock_Demo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Ticket ticket = new Ticket();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i <5000001; i++) {
            executorService.execute(() -> {
//                while (ticket.flag) {
                if (ticket.ticket >= 0) {
                    try {
                        lock.lock();
                        ticket.saleTicket();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
//                }
            });
        }
        while(ticket.flag){
            Thread.yield();
        }
        System.out.println("lock"+(ticket.end-start));
    }
    @Test
    public void test1() throws InterruptedException {
        Ticket ticket = new Ticket();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        long start = System.currentTimeMillis();;
        for (int i = 0; i <5000001; i++) {
            executorService.execute(()->{
//                while(ticket.flag) {
                if(ticket.ticket>=0){
                    synchronized (ticket) {
                        try {
                            ticket.saleTicket();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
//                }
            });
        }
    while(ticket.flag){
            Thread.yield();
    }
        System.out.println("synch"+(ticket.end-start));
    }

}
class Ticket {
    public int ticket = 5000000;
    public volatile boolean flag = true;
    public long end;

    public void saleTicket() throws InterruptedException {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket-- + "张票");
        } else {
            end = System.currentTimeMillis();
            flag = false;
        }
    }
}*/
