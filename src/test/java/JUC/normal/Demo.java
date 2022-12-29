package JUC.normal;
/*
* 传统开启多线程的方式
*       子类继承Thread类
*       实现类实现Runnable接口
* 现在开启多线程
*       使用lambda表达式匿名内部类的方式
*       多个线程共同操作的资源，建立一个单独的class来管理
*   例如卖票的例子
* */
    public class Demo {
        public static void main(String[] args) {
    //        Ticket ticket = new Ticket();
            Ticket2 ticket = new Ticket2();
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.sale();
            },"a").start();
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.sale();
            },"b").start();
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.sale();
            },"c").start();
        }
    }
    class Ticket{
        boolean flag=true;
        //保证可见性，不保证原子性
        volatile int number=10;



        public void sale(){
            while(flag){
                if(number==0){
                    flag=false;
                    break;
                }
                //打印语句是同步方法，多个线程排队执行
                System.out.println(Thread.currentThread().getName()+"正在卖第"+number--+"张票");
            }
        };
    }
/*
* 这里存在一个问题，为什么println是同步方法，为什么number还有出现线程安全问题呢？
*System.out.println(Thread.currentThread().getName()+"正在卖第"+number--+"张票");
* 通过反编译Ticket.class(javap -c Ticket.class)
* 得到System.out.println(Thread.currentThread().getName()+"正在卖第"+number--+"张票")的字节码指令
* 如下：
  public void sale();
    Code:
       0: aload_0
       1: getfield      #2                  // Field flag:Z
       4: ifeq          74
       7: aload_0
       8: getfield      #3                  // Field number:I
      11: ifne          22
      14: aload_0
      15: iconst_0
      16: putfield      #2                  // Field flag:Z
      19: goto          74
      22: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
      25: new           #5                  // class java/lang/StringBuilder
      28: dup
      29: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
      32: invokestatic  #7                  // Method java/lang/Thread.currentThread:()Ljava/lang/Thread;
      35: invokevirtual #8                  // Method java/lang/Thread.getName:()Ljava/lang/String;
      38: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      41: ldc           #10                 // String 正在卖第
      43: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      46: aload_0
      47: dup
      48: getfield      #3                  // Field number:I
      51: dup_x1
      52: iconst_1
      53: isub
      54: putfield      #3                  // Field number:I
      57: invokevirtual #11                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      60: ldc           #12                 // String 张票
      62: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      65: invokevirtual #13                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      68: invokevirtual #14                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      71: goto          0
      74: return
}
简而言之：
        1.从主存中获取number
        2.执行number--
        3.执行println语句（原子性操作，因为它是同步方法）
        总而言之，System.out.println并不是线程安全的
* */

//保证线程安全的共享资源类，卖票的方法用了synchronized
class Ticket2{
    boolean flag=true;
    //保证可见性，不保证原子性
    volatile int number=10;
    public synchronized void sale(){
        while(flag){
            if(number==0){
                flag=false;
                break;
            }
            //打印语句是同步方法，多个线程排队执行
            System.out.println(Thread.currentThread().getName()+"正在卖第"+number--+"张票");
        }
    };

};