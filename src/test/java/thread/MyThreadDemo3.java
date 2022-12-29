package thread;



public class MyThreadDemo3 extends Thread{
    //共享变量
    private int ticket=100;

    public int getTicket() {
        return ticket;
    }

    private String str=new String("2321");

    @Override
    public void run() {
        while (true) {
            synchronized (str) {
                if (ticket >0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + ticket--);
//                    for (int i = 0; i <100; i++) {
//                        ticket++;
//                    }
//                    System.out.println(Thread.currentThread().getName()+ticket);
//                    break;
                }
            }
        }
    }
}
