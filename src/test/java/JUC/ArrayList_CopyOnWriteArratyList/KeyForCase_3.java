package JUC.ArrayList_CopyOnWriteArratyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/*
* 解决ArrayList线程不安全问题方案3
* 使用java并发包下的CopyOnWriteArrayList类
* 原理使用了读写分离的思想，写入时使用了synchronized代码块同步线程
* 读取数据时没有使用synchronized，提高效率
*
* */
public class KeyForCase_3 {
    public static void main(String[] args) throws InterruptedException {
        SchoolIII school = new SchoolIII();
        for (int i = 0; i <100 ; i++) {
        final int temp=i;
        new Thread(()->{
            school.recruitStudent(temp+"");
        },temp+"号学生").start();
    }
        TimeUnit.SECONDS.sleep(3);
        school.printArrayList();
}
}
class SchoolIII{
    private List<String> student= new CopyOnWriteArrayList<String>();

    public void recruitStudent(String name){
        student.add(name);
    }
    public void graduate(String name){
        student.remove(name);
    }

    public void printArrayList(){
        System.out.println(student.size());
    }
}