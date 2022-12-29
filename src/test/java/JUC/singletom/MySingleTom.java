package JUC.singletom;
/*
* 单例模式：整个程序中只存在一个对象
* 饿汉式单例模式：一上来就new 对象，占用内存空间
* */
public class MySingleTom {
    //为什么声明为类变量?所有对象所共享的
    //为什么声明为常量？地址值不需要改变
    //声明为private，不能使用类名.singleTom
    public static int a=10;
    private final static MySingleTom singleTom=new MySingleTom();
    private int[] data= new int[100024*1024];
    private int[] data1= new int[1024*1024];
    private int[] data2= new int[1024*1024];
    private int[] data3= new int[1024*1024];
    private MySingleTom(){

    }

    public static MySingleTom getSingleTom() {
        return singleTom;
    }
}
