package thread.Thread_join;
/*
* Thread类中有一个方法，可以让当前线程插队，一直处于Runable状态，其他的线程都进入阻塞状态
* Thread.join
* */
public class ThreadJoin implements Runnable{
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("VIP线程来了"+i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();

        for (int i = 0; i <500 ; i++) {
            if (i==100){
                //子线程插队，main线程进入阻塞
                thread.join();
            }
            System.out.println("mian线程"+i);
        }
    }
}
