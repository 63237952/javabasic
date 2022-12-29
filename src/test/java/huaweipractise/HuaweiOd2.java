package huaweipractise;

import java.util.*;
/*
* 描述
输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
保证输入的整数最后一位不是 0 。

数据范围： 1<=n<=10^8
输入描述：
输入一个int型整数
输出描述：
按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
*
*
* */
//关键词：字符串反转、set集合去重、拼接字符串、

public class HuaweiOd2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> set=new TreeSet<String>();
        Map<Integer, String> map = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if (a<1||a>Math.pow(10,8)) {
                continue;
            }
            String a_str = String.valueOf(a);
            //获得字符串的长度
            int length = a_str.length();
            int j=0;
            //保证字符串的最后一位不为0
            if(a_str.substring(length-1).equals("0")){
                continue;
            }
            //将字符串反转，从右边开始读取
            String a_str_ = stringBuffer.append(a_str).reverse().toString();
            for (int i = 0; i <length ; i++) {
                //当字符串读取到末尾时，截取字符串的方式发生改变
                if(i==length-1){
                    String element_last = a_str_.substring(i);
                    if(set.contains(element_last)){
                        continue;
                    }
                    set.add(element_last);
                    map.put(j,element_last);
                    j++;
                }else {
                    //从左边开始读取字符串，并放入set和map集合中，set用来去重
                    String element = a_str_.substring(i, i + 1);
                    if(set.contains(element)){
                        continue;
                    }
                    set.add(element);
                    map.put(j,element);
                    j++;
                }
            }
            System.out.println(map);
            //使用StringBuilder用来拼接map中的元素
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < map.size(); i++) {
                stringBuilder.append(map.get(i));
            }
            //转化为字符串类型
            String s = stringBuilder.toString();
            //转化为整形
            System.out.println(Integer.valueOf(s));
        }
    }
}
