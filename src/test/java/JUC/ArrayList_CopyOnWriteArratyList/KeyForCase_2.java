package JUC.ArrayList_CopyOnWriteArratyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/*
* 解决ArrayList线程不安全问题方案2
* 使用Collections集合工具类的synchronizedList方法
* */
public class KeyForCase_2 {
    public static void main(String[] args) throws InterruptedException {
        SchoolII school = new SchoolII();
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
class SchoolII{
    private List<String> student= Collections.synchronizedList(new ArrayList<String>());

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