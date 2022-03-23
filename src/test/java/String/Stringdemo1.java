package String;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stringdemo1 {
    @Test
    public void demo1(){
        /*常用方法*/
        //字符串比较 equals
        String s1 = new String("abcd");
        String s2 = new String("abcd");
        boolean equals = s1.equals(s2);
        System.out.println(equals);
    }
    @Test
    public void demo2(){
        /*常用方法*/
        //字符串比较忽略大小写 equalsIgnoreCase
        String s1 = new String("abcd");
        String s2 = new String("Abcd");
        boolean equals = s1.equalsIgnoreCase(s2);
        System.out.println(equals);
    }
    @Test
    public void demo3(){
        /*常用方法*/
        //获取字符串长度 length
        String s1 = new String("abcd");

        System.out.println(s1.length());
    }

    @Test
    public void demo4(){
        /*常用方法*/
        //拼接字符串 concat
        String s1 = new String("abcd");
        System.out.println(s1.concat(new String("efg")));
    }

    @Test
    public void demo5(){
        /*常用方法*/
        //从指定索引开始截取字符串 subString（int beginIndex）
        String s1 = new String("abcd");
        System.out.println(s1.substring(2));
    }


    @Test
    public void demo6(){
        /*常用方法*/
        //将字符串转化为字符数组 toCharArray（）
        String s1 = new String("abcd");
        char[] chars = s1.toCharArray();
        System.out.println(chars);
    }

    @Test
    public void demo7(){
        /*常用方法*/
        //将字符串转化为字节数组 getBytes()
        String s1 = new String("abcd");
        byte[] bytes = s1.getBytes();
        for (int i = 0; i <bytes.length ; i++) {
            System.out.println(bytes[i]);
        }
    }

    @Test
    public void demo8(){
        /*常用方法*/
        //分割字符串 spilt（）
        String s1 = new String("a、b、c、d");
        String[] split = s1.split("、");
        for (int i = 0; i <split.length ; i++) {
            System.out.print(split[i]);
        }
    }

    @Test
    public void demo9(){
        /*常用方法*/
        //练习 将日期类转化为字符串输出
        Date date = new Date();
        String format = String.format("%tF", date);
        System.out.println(format);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date);
        System.out.println(format1);
    }
}
