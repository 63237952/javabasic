package thread.Thread_daemon;
/*
* 线程分为守护线程和用户线程
* jvm保证用户线程执行完毕后才能终止程序
* jvm不保证守护线程执行完成，只要用户线程执行完毕，jvm虚拟机也会停止工作
*
* 之前默认开启的线程都是用户线程
* Thread提供一个方法可以将线程设置为守护线程：thread.setDaemon(true);
* ------------------------------------------------------------------------
*
* */
public class Thread_daemon implements Runnable{

    public void run() {
        while(true){
            System.out.println("守护线程在执行中");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread_daemon thread_daemon = new Thread_daemon();
        Thread thread = new Thread(thread_daemon, "守护线程");
        //设置为守护线程
        thread.setDaemon(true);
        //开启守护线程
        thread.start();
        //main线程sleep 2秒后结束，守护线程到时候也将终止。
        Thread.sleep(2000);
    }
}
