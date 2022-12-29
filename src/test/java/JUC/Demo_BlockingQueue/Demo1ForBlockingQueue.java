package JUC.Demo_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/*
*阻塞队列BlockingQueue接口
* 实现类ArrayBlockingQueue
* 顶层父类Collection
*阻塞队列的有四组添加和移除元素的方法
* 第一组：add/remove 如果队列满了会抛出异常
* 使用这组api来操作队列，如果出现异常，则会抛出异常
* */
public class Demo1ForBlockingQueue {
    public static void main(String[] args) {
        pool pool = new pool();
        for (int i = 0; i <4 ; i++) {
            final int temp=i;
            new Thread(()->{
                pool.add(String.valueOf(temp));
            },i+"").start();
        }
        for(int i = 0; i <4 ; i++) {
            final int temp=i;
            new Thread(()->{
                pool.remove();
            },i+"out").start();
        }

    }
}
class pool{
   private ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
   public void add(String string){
       try {
           System.out.println(Thread.currentThread().getName()+"存入元素成功"+queue.add(string));
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println(Thread.currentThread().getName()+"存入元素失败");
       }

   }
   public String remove(){
       String element = null;
       try {
           element = queue.remove();
       } catch (Exception e) {
           e.printStackTrace();
       }
       System.out.println(Thread.currentThread().getName()+"取出元素成功"+element);
       return element;

   }
}