package JUC.communication;
/*
* 在Thread_Communication模拟了多线程通信下出现了虚假唤醒的情况导致出现了预想之外的结果。
* 在这里使用while()替代if()可以解决虚假唤醒的情况发生
* 虚假唤醒：唤醒的不是真正需要唤醒的线程
*
* */
public class Thread_Communication2 {

    public static void main(String[] args) {
        ProductII product = new ProductII();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.production();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者线程a1").start();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.consumption();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者线程b").start();
        new Thread(()->{
            try {
                for (int i = 0; i <5 ; i++) {
                    product.consumption();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者线程c").start();
    }
}
class ProductII{
    int product=0;
    //生产方法
    public synchronized void production() throws InterruptedException {

        while (product!=0){
            wait();
        }
        product++;
        System.out.println("产品数量为"+product+"通知消费者线程");
        this.notifyAll();
    }
    //消费方法
    public synchronized void consumption() throws InterruptedException {
        while (product==0){
            wait();
        }
        product--;
        System.out.println("产品数量为"+product+"通知生产者线程");
        this.notifyAll();
    }
}