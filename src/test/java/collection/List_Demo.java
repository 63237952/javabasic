package collection;

import org.junit.Test;
import org.junit.rules.Stopwatch;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//测试list集合：
/*
* list顶层父类为collection
* arraylist底层使用的是数组
* 数组初始长度为10，每当数组的长度到达阈值时
* 数组的长度就会以1.5倍扩容
*
* */
public class List_Demo {
    public static void main(String[] args) throws IOException {
        //初始化list容器
        List<Byte[]> list=new ArrayList();
        //容器添加两个元素
        list.add(new Byte[10]);
        list.add(new Byte[10]);
        list.add(1,new Byte[2]);
        System.out.println("集合的长度为："+list.size());
        System.in.read();
        //list引用置为null，可以被垃圾回收
        list=null;
        System.gc();
        System.in.read();
        //为什么byte超范围，没有报错？虽然取值超出了范围，但是byte只取低八位
        byte b=(byte)1032;
        System.out.println(b);
        //清除列表的所有元素
//        list.clear();

    }

  /*
*
* 测试ArrayList的随机遍历和顺序遍历效率
* for和iterator的效率比较：
* 结论：数据量大时，iterator效率比for高
* */

    @Test
    public void test1(){
        List list=new ArrayList<Integer>();
        for (int i = 0; i <50000000 ; i++) {
            list.add(i);
        }

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
          iterator.next();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("随机遍历花费的时间："+(end1-start1));
        System.out.println("顺序遍历花费的时间："+(end2-start2));
    }
    /*
    * 比较arraylist和linkedlist添加元素的效率：array比linked更有优势
    * */
    @Test
    public void test2(){
        List<Integer> link_list = new LinkedList();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i <10000000 ; i++) {
            link_list.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Linkedlist的添加元素的时间"+(end1-start1));
        //===============================================================
        List<Integer> array_list = new ArrayList();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i <10000000 ; i++) {
            array_list.add(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("array_list的添加元素的时间"+(end2-start2));
    }
    /*
     * 比较arraylist和linkedlist遍历元素的效率：array比linked更有优势
     * */
    @Test
    public void test3(){
        List<Integer> link_list = new LinkedList();
        List<Integer> array_list = new ArrayList();
        for (int i = 0; i <10000000 ; i++) {
            link_list.add(i);
        }

        for (int i = 0; i <10000000 ; i++) {
            array_list.add(i);
        }
        long start1 = System.currentTimeMillis();
        Iterator<Integer> iterator = link_list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Linkedlist的遍历元素所用时间"+(end1-start1));
//=======================================================================
        long start2 = System.currentTimeMillis();
        Iterator<Integer> iterator2 = array_list.iterator();
        while (iterator2.hasNext()){
            Integer next = iterator2.next();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("array_list的遍历元素所用时间"+(end2-start2));
    }
    /*
    *
    * 比较arraylist和linkedlist插入操作：
    * */
    @Test
    public void test4(){
        List<Integer> link_list = new LinkedList();
        List<Integer> array_list = new ArrayList();
        for (int i = 0; i <1000000 ; i++) {
            link_list.add(i);
        }

        for (int i = 0; i <1000000 ; i++) {
            array_list.add(i);
        }
        long start1 = System.currentTimeMillis();
            link_list.add(5000,000);
        long end1 = System.currentTimeMillis();
        System.out.println("Linkedlist的插入元素所用时间"+(end1-start1));
//=======================================================================
        long start2 = System.currentTimeMillis();
            array_list.add(5000,000);
        long end2 = System.currentTimeMillis();
        System.out.println("array_list的插入元素所用时间"+(end2-start2));
    }
    /*
    * 测试arraylist的线程不安全问题
    * 使用两个线程对公共资源arraylist进行写操作
    * 最终证明是线程不安全的
    * */
    @Test
    public void test5() throws InterruptedException {
        Utils_demo utils_demo = Utils_demo.getUtils_demo();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()->{
            utils_demo.operationList();
        });
        executorService.execute(()->{
            utils_demo.operationList();
        });

        Thread.sleep(2000);
        System.out.println(utils_demo.getArrayList().size());
    }
    /*
    * 线程安全的List
    * 使用费Collections工具类中的synchronizedList方法
    * 读写都加了锁，不是最优选择，因为一般的业务场景中的读操作都要大于写操作，使用这个类，效率低
    * */
    @Test
    public void test6() throws InterruptedException {
        Utils_demo utils_demo = new Utils_demo();
        List<String> safe_List = Collections.synchronizedList(utils_demo.getArrayList());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()->{
            long t1 = System.currentTimeMillis();
            for (int i = 0; i <100000 ; i++) {
              safe_List.add(Integer.toString(i));
            }
            long t2 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"finish"+(t2-t1));
        });
        executorService.execute(()->{
            long t3 = System.currentTimeMillis();
            for (int i = 0; i <100000 ; i++) {
                safe_List.add(Integer.toString(i));
            }
            long t4 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"finish"+((t4-t3)));
        });
        Thread.sleep(2000);
        Thread.sleep(2000);
        long t5 = System.currentTimeMillis();
        for (int i = 0; i <safe_List.size(); i++) {
            String s = safe_List.get(i);
        }
        long t6 = System.currentTimeMillis();
        System.out.println(t6-t5);
    }
    static class Utils_demo{
        private Utils_demo(){};
        private static  Utils_demo utils_demo=new Utils_demo();
        private ArrayList<String> arrayList=new ArrayList();
        public static Utils_demo getUtils_demo() {
            return utils_demo;
        }
        public ArrayList<String> getArrayList() {
            return arrayList;
        }
        public void operationList(){
            for (int i = 0; i <10000 ; i++) {
                this.arrayList.add(Integer.toString(i));
            }
            System.out.println(Thread.currentThread().getName()+"finish");
        }
    }
    @Test
    public void test7() throws InterruptedException {
        CopyOnWriteArrayList<String> list= new CopyOnWriteArrayList();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()->{
            long t1 = System.currentTimeMillis();
            for (int i = 0; i <100000 ; i++) {
                list.add(Integer.toString(i));
            }
            long t2 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"finish"+(t2-t1));
        });
        executorService.execute(()->{
            long t3 = System.currentTimeMillis();
            for (int i = 0; i <100000 ; i++) {
                list.add(Integer.toString(i));
            }
            long t4 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"finish"+(t3-t4));
        });
        Thread.sleep(60000);
        long t5 = System.currentTimeMillis();
        for (int i = 0; i <list.size(); i++) {
            String s = list.get(i);
        }
        long t6 = System.currentTimeMillis();
        System.out.println((t6-t5));
    }
    /*
    * 测试CopyOnWriteArrayList在遍历的过程中是否安全：
    * 在CopyOnWriteArrayList使用迭代器遍历的过程中，开辟另外一个线程来改变集合的结构（remove）
    * 是否影响遍历的结果
    * 经过验证，不会影响遍历的结果，因为迭代器遍历的是旧的集合的引用，而改变结构后只是指向新的集合
    *
    * */
    @Test
    public void test8() throws InterruptedException {
        CopyOnWriteArrayList<String> list= new CopyOnWriteArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()->{
            for (String s : list) {
                System.out.println(s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(2);
            System.out.println(list);
        });

        Thread.sleep(2000);
    }
}
