package thread.synchronnized;

public class Father {
    private int a=10;
    public synchronized void doSomething(){
        System.out.println("父类的方法执行了"+a--);
        while(true){

        }
    }
}
