package JUC.ArrayList_CopyOnWriteArratyList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
* ArrayList是一个线程不安全的集合
*案例：
* 开启100个线程不断的往School中添加学生
* 最后打印ArrayList的长度，发现长度有时候不是100
* 因为ArrayList集合不是线程安全的集合，其add方法并没有加synchronized关键字，多个线程
* 同时操作时，可能会存在覆盖的问题
* */
public class Demo1_ArrayList {
    public static void main(String[] args) throws InterruptedException {
        School school = new School();
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
class School{

    private List<String> sturent=new ArrayList<String>();

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