package JUC.ArrayList_CopyOnWriteArratyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/*
* 对于ArrayList在多线程环境下，线程不安全的解决方案1
* 使用Vector集合
*
* */
public class KeyForCase_1 {
    public static void main(String[] args) throws InterruptedException {
        SchoolI school = new SchoolI();
        for (int i = 0; i <1000 ; i++) {
            final int temp=i;
            new Thread(()->{
                school.recruitStudent(temp+"");
            },temp+"号学生").start();
        }
        TimeUnit.SECONDS.sleep(3);
        school.printArrayList();

            }
}
class SchoolI{
    //Vector是ArrayList的子类，它重写了父类的add方法，该方法上加了synchronized关键字，变成了同步的方法，所以它是线程安全的。
    private List<String> sturent=new Vector<String>();

    public void recruitStudent(String name){
        sturent.add(name);
    }
    public void graduate(String name){
        sturent.remove(name);
    }

    public void printArrayList(){
        System.out.println(sturent.size());
    }
}