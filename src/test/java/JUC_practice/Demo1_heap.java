package JUC_practice;

import java.util.ArrayList;
import java.util.List;
/*
* 堆内存溢出的案例
*
* */
public class Demo1_heap {
    public static void main(String[] args) {
        int i=0;
        try {
            List<String> list=new ArrayList();
            String str="hello";
            while(true){
                Thread.sleep(2000);
                i++;
                list.add(str);
                //循环27次后，str占用内存容量过大，导致堆内存溢出d
                str=str+str;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
