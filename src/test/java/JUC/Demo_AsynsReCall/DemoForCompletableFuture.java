package JUC.Demo_AsynsReCall;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/*
* 异步回调：时用到的类CompletableFuture
*       方法：CompletableFuture<Void> runAsync(Runnable runnable) （无返回值）
*             CompletableFuture<U> supplyAsync(Supplier<U> supplier)(有返回值)
*
 * */
public class DemoForCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+"正在执行异步任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        CompletableFuture<Integer> integerCompletableFuture = completableFuture.supplyAsync(() -> {
//            return 123;
//        });
        //获取返回值，主线程阻塞，直到执行完成，后面的代码无法执行
//        completableFuture.get();

        completableFuture.thenAccept((value)->{
            System.out.println("异步任务执行完成");

       });

        System.out.println(Thread.currentThread().getName()+"正在执行");
        TimeUnit.SECONDS.sleep(2);
    }
}
