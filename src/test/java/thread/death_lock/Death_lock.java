package thread.death_lock;
/*
* 死锁是一种在多线程运行环境下可能会产生的一种导致程序阻塞的一种现象
* 产生的原因：多个线程互相占用各自所需的资源而处于无线等待的状态
*
* */
public class Death_lock implements Runnable {
    private FootBall footBall;
    private BasketBall basketBall;
    public Death_lock(FootBall footBall, BasketBall basketBall){
        this.footBall=footBall;
        this.basketBall=basketBall;
    }
    public void run() {
        /*
        * 如果先进来是james线程，他就先拿到足球，然后让james线程休眠，目的是为了让
        * curry线程同时也进入到run方法中，curry会拿到篮球
        * 这样他们就各自占用了足球了篮球的资源，但是他们接下来都想去获取对方锁占用的资源，
        * 但是在这里的写法中他们占用资源还未释放，又想去获得对方的资源，所以两个线程都在等待
        * 对方释放资源的blocked状态
        *这就是死锁现象
        * */
        if ("james" == Thread.currentThread().getName()) {
            synchronized (footBall) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "拿到了足球" + footBall);
                synchronized (basketBall) {
                    System.out.println(Thread.currentThread().getName() + "拿到了篮球" + basketBall);
                }
            }
        } else {
            synchronized (basketBall) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "拿到了足球" + footBall);
                synchronized (footBall) {
                    System.out.println(Thread.currentThread().getName() + "拿到了篮球" + basketBall);
                }
            }
        }
    }
    public static void main(String[] args) {
        Death_lock death_lock = new Death_lock(new FootBall(), new BasketBall());
        new Thread(death_lock,"james").start();
        new Thread(death_lock,"curry").start();
    }
}
class FootBall{}
class BasketBall{}