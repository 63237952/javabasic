package string;

public class StringTableTest {
    public static void main(String[] args) {
        /*        //创建字符串对象“a”并放入到串池中
        String s="a";
        //创建字符串对象“b”并放入到串池中
        String s1="b";
        //创建字符串对象“ab”，放入到堆中
        String s2=s+s1;
        //创建字符串对象“ab”，放入到串池中
        String s3="a"+"b";
        //s2是指向的堆中，s3指向的串池中，地址不一样
        System.out.println(s2==s3);*/

        String s=new String("a")+new String("b");
        //intern把堆中的“ab”放在常量池中，s也指向了常量池中的“ab”，如果常量池
        String s1 = s.intern();
        System.out.println(s1==s);

    }
}
