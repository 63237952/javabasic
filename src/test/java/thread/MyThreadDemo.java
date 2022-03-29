package thread;
//模拟线程安全问题

public class MyThreadDemo extends Thread{
    private  int ticket =100;
    //使用同步方法来对解决线程安全问题
    //同步方法用的锁对象是this
    //静态的同步方法锁对象是MyThreadDemo.class对象
    public  synchronized void sellticket(){
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
        while(true){
            sellticket();
        }
    }
}
