package thread.synchronnized;

public class SyNchronnizedTest {
    /*
    * 锁的可重入性：一个线程请求它正在占用的锁时，请求会成功
    *
    * 锁的可重入性测试son调用doSomething方法进入同步代码方法中，同步方法锁的是调用者的实例
    * 当调用父类的doSomething方法时，由于又要进入父类的同步方法中，此时又要获得锁，因为此时Son的同步方法又还没有释放锁，
    * 此时按理来说，无法进入到父类的doSomething中去，但实际测试的结果是，可以进入到父类的同步方法中
    *
    * 结论：当一个线程请求拿自己占用的锁时，请求会成功，这就是锁的可重入机制
    * */
    public static void main(String[] args) {
        Son son = new Son();
        //当前main线程调用doSomething同步方法时，会请求锁，锁对象是son
        son.doSomething();

    }
}
