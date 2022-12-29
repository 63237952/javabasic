package thread.Thread_synchronized;
/*
* 这个银行取钱的案例中，存在线程不安全问题
* 两个线程存在共享数据account
* 当两个线程并发对account进行写操作时
* 可能存在线程不安全问题
* 解决线程不安全问题的方式是使用同步代码块
*为什么run方法加锁无法实现线程数据同步？
* 因为同步方法锁的是this，然而这里的两个线程是通过extends Thread实现的
* 当使用同步方法加锁时，然而这两个线程在请求锁时，分别请求的是各自的线程对象。
*也就是说两个线程使用的是两把锁，没有形成两个线程竞争锁的情况，自然没办法解决线程安全。
*
* */
public class Bank_case extends Thread{
    private volatile Account account;
    private int getMoney;
    private String name;
    public Bank_case(Account account,int getMoney,String name){
        super(name);
        this.account=account;
        this.getMoney=getMoney;
    }
    @Override
    public void run() {
//        synchronized (account) {
        if (account.getMoney() - getMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "取钱:卡中余额不足");
            return;
        }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int balance = account.getMoney() - getMoney;
            account.setMoney(balance);
            System.out.println(Thread.currentThread().getName() + "取钱：账户余额为" + account.getMoney() + "元");
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        //一个账户
        Account account = new Account("结婚基金", 100);
        Bank_case myself = new Bank_case(account, 50, "myself");
        Bank_case girfriend = new Bank_case(account, 100, "girfriend");
        myself.start();
        girfriend.start();
        Thread.sleep(2000);
        System.out.println(account.getMoney());
    }
}
class Account{
    private String name;
    private int money;
    public Account(String name,int money){
        this.name=name;
        this.money=money;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
