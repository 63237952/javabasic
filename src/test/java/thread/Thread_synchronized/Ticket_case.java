package thread.Thread_synchronized;
/*
* 多线程线程不安全案例：卖票
* 开启三个线程来卖票
* 三个线程同时对共享数据进行了写操作
* 出现票数异常的情况
* 使用synchronized关键字解决线程不安全问题
* 加在方法上锁的是this对象
*
* */
public class Ticket_case implements Runnable {
    private int ticket=10;
    private boolean flag=true;
    public void run() {
        while(flag){
            try {
                Thread.sleep(500);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void buy(){
        //尤其注意这里，当某一个线程卖出最后一张票时，其他两个线程还是在等待拿到锁的过程中
        //即使卖出最后一张票的线程已将flag修改至false了，但是其他两个线程还在while的循环中，
        // 并不会退出while循环，这里做了一个判断，如果ticket为0，剩余的线程不在执行卖票操作
        //直接返回
        if (ticket==0){
            flag=false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"---"+"正在卖第"+ticket--+"张票");


    }
    public static void main(String[] args) {
        Ticket_case ticket = new Ticket_case();
        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
