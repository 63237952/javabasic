package thread.synchronnized;

public class Son extends Father {
    //子类重写父类的方法doSomething
    @Override
    public synchronized void doSomething(){
        System.out.println(this+"子类的方法执行了");
        //调用父类的doSomething同步方法，请求锁（son），此时son锁还未释放，但是请求依然成功，因为该线程请求的是自己占用的锁
        super.doSomething();

    }
}
