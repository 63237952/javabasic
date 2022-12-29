package thread;

public class MyThreaddemo2 extends Thread {

    private static int ticket =100;
    //使用静态的同步方法来对解决线程安全问题
    //同步方法用的锁对象是调用者的class对象
    //静态的同步方法锁对象是MyThreadDemo.class对象
    public  static  synchronized void sellticket(){
        if(ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖出了第"+ticket+"张票");
            --ticket;
        }
    }
    @Override
    public void run() {
        System.out.println(MyThreaddemo2.class);
        while(true){
            MyThreaddemo2.sellticket();
        }
    }
}
