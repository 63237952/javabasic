package JUC.Demo_cas;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
* 原子引用：带版本号的，避免出现ABA问题
*
* */
public class DemoForAtomicReference {
    private static AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<Integer>(2020,1);
    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"修改的版本号"+integerAtomicStampedReference.getStamp());
            System.out.println(integerAtomicStampedReference.compareAndSet(2020, 2022, 1, integerAtomicStampedReference.getStamp() + 1));
            System.out.println(Thread.currentThread().getName()+"修改的版本号"+integerAtomicStampedReference.getStamp());
            System.out.println(integerAtomicStampedReference.compareAndSet(2022, 2020, 2, integerAtomicStampedReference.getStamp() + 1));
            System.out.println(Thread.currentThread().getName()+"修改的版本号"+integerAtomicStampedReference.getStamp());
        },"捣乱的线程").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"修改的版本号"+integerAtomicStampedReference.getStamp());
            System.out.println(integerAtomicStampedReference.compareAndSet(2020, 2022, 1, integerAtomicStampedReference.getStamp() + 1));
        },"预期的线程").start();
    }
}
