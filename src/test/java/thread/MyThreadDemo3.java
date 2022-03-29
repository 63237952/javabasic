package thread;



public class MyThreadDemo3 extends Thread{
    private int ticket=100;
    private String str=new String("2321");

    @Override
    public void run() {
        while (true) {
            synchronized (str) {

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + ticket--);
                }
            }
        }
    }
}
