package JUC.Demo_ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/*
* ForkJoin：是jdk提供的一个类，用于解决大数据量的计算问题
* 其思想是，将一个具有大数量的任务分解成小任务，并由多个线程来计算，最后将所有线程任务结果合并起来
* 达到提高效率的目的
* ForkJoinPool：是执行拆分任务的池子
* ForkJoinTask: 代表任务，这个类的作用是将任务拆分，并且任务拆分后处理
* 它有两个子类：RecursiveTask<V> 和RecursiveAction，这两个类是实际用到的类，一个类有返回值，一个没有返回值
* 步骤：
* 1.构建一个类继承RecursiveTask<V> 或RecursiveAction，并实现compute方法
* 2.compute里定义如何将任务进行拆分，并且拆分过后的处理
* 3.创建ForkJoinPool来开启任务的拆分和处理
* 案例：
* 将1-100000的数字进行累加
* 数据量越大，ForkJoin的速度越快于普通的算法
* 注意：for循环进行计算时，要使用long基本类型来参与计算，否则会引起频繁的装箱和拆箱消耗时间
* */
public class DemoForForkJoin extends RecursiveTask<Long>{
    Long start;
    Long end;
    Long temp;

    public DemoForForkJoin(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end-start<100000000){
            long sum=0L;
            for (long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        }else {
            long middle=(start+end)/2;
            DemoForForkJoin task1 = new DemoForForkJoin(start, middle);
            task1.fork();
            DemoForForkJoin task2 = new DemoForForkJoin(middle+1,end);
             task2.fork();
            return task1.join()+task2.join();
        }
    }

    public Long normalCompute(){
        //倘若把类型转化使用包装类Long，则运算的速度会慢很多，因为包装类在计算时要不断的装箱和拆箱
        long sum=0L;
        for (long i = start; i <=end ; i++) {
            sum+=i;
        }
        return sum;

        /*
        *     //装箱，Long sum=Long.valueOf(0L)
        *    Long sum=0L;
        *    for (Long i = start; i <=end ; i++) {
        *           //sum=sum+i==>相当于Long.valueOf(sum.intValue()+i.intValue())
        *           //i++==>i=i+1==>Long.valueOf(i.intValue()+1)
         *            sum+=i;
        *          }
         *    return sum;
        * */
    }
}
class Test123{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
//        test2();
    }
    public static void test1(){
        long start=System.currentTimeMillis();
        DemoForForkJoin demoForForkJoin = new DemoForForkJoin(1L, 1000000000L);
        System.out.println(demoForForkJoin.normalCompute());
        long end=System.currentTimeMillis();
        System.out.println(end-start+"test1");
    }
    public  static void test2() throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        DemoForForkJoin demoForForkJoin = new DemoForForkJoin(1L, 1000000000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(demoForForkJoin);
        Long aLong = submit.get();
        System.out.println(aLong);
        long end=System.currentTimeMillis();
        System.out.println(end-start+"test2");
    }
}
//Exception in thread "ForkJoinPool-1-worker-13" java.lang.NoClassDefFoundError: Could not initialize class java.util.concurrent.locks.AbstractQueuedSynchronizer$Node
//java.lang.StackOverflowError