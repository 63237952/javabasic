package collection;

//import com.sun.crypto.provider.PBKDF2Core;

import java.util.HashSet;
import java.util.Set;
/*
* 遍历set集合的时候并不是按存储的顺序进行取出的
* */
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<Integer>();
        set.add(2);
        set.add(12);
        set.add(3);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
