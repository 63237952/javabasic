package collection;

import java.util.HashMap;
import java.util.Map;
/*
* map集合的特点：
* 以键值对的方式存储元素
* 可以存储null值（健和值都可以是null）
* 适合做添加、删除和定位元素
*
* */
public class HashMap_Demo {
    public static void main(String[] args) {
        Map map=new HashMap();
        String str="123";
        map.put("key","value");
        Object put = map.put(null, null);
        System.out.println(map);
        Object key = map.get("key");
        System.out.println(key);
    }
}
