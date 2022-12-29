package JUC.communication;
/*
* 生产者和消费者问题
* 在多线程的环境下，有些需要有可能是需要线程之间相互通信才能完成的
* 生产者和消费者就是多线程的典型案例
* 生产和消费不能并发进行，必须是生产完了，才能消费
*注意：wait和notify必须在synchronized关键字作用范围内使用，否则会抛出java.lang.IllegalMonitorStateException
* */
public class Thread_Communication {

    public static void main(String[] args) {
        Product product = new Product();
        new Thread(()->{
            try {
                for (int i = 0; i <100 ; i++) {
                    product.production();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者线程a").start();
        new Thread(()->{
            try {
                for (int i = 0; i <50 ; i++) {
                    product.consumption();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者线程b").start();
        /*
        * 开启第三个线程，让他也参与到消费
        * 这种情况下，生产者生产结束后通知唤醒消费者，此时的消费者有两个，消费者1抢占到锁后
        * 会开始消费，唤醒所有线程，又释放锁，此时的消费者2已经被唤醒，当消费者2抢占到锁后
        * 它会接着执行wait()后面的代码，也就是跳出了if的作用范围，不会在进行判断了，所以
        * 此时消费者2是可以抢占到锁的，消费者2抢占到锁后，产品将会出现负数的情况。
        * 出现的原因是由于使用了if判断，导致出现的虚假唤醒。
        * 使用while替代if可以解决虚假唤醒的问题
        * */
        new Thread(()->{
            try {
                for (int i = 0; i <50 ; i++) {
                    product.consumption();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者线程c").start();
    }
}
class Product{
    int product=0;
    //生产方法 synchronized synchronized
    public synchronized void production() throws InterruptedException {

        if (product!=0){
            wait();
        }
        product++;
        System.out.println("产品数量为"+product+"通知消费者线程");
        this.notifyAll();
    }
    //消费方法
    public synchronized void consumption() throws InterruptedException {
        if (product==0){
            wait();
            Thread.sleep(100);
        }
        product--;
        System.out.println(Thread.currentThread().getName()+""+"产品数量为"+product+"通知生产者线程");
        this.notifyAll();
    }
}