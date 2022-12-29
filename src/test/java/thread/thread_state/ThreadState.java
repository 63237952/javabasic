package thread.thread_state;
/*
* Thread类中的getState可以获得线程的状态
* */
public class ThreadState implements Runnable {
    private static boolean flag=true;
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=false;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadState threadState = new ThreadState();
        Thread a = new Thread(threadState, "a");
        Thread b = new Thread(threadState, "b");
        Thread.State state_a = a.getState();
        System.out.println(state_a);
        Thread.State state_b = b.getState();
        System.out.println(state_b);
        a.start();
        b.start();
        while(flag){
            Thread.sleep(1);
            state_a=a.getState();
            state_b=b.getState();
            System.out.println(state_a+"线程a");
            System.out.println(state_b+"线程b");
        }
    }
}
