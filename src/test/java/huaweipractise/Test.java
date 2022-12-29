package huaweipractise;



import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Test {
    static char[] chars;
    static StringBuilder stringBuilder=new StringBuilder();
    static String result="";
    public static void main(String[] args) {
        chars = new char[26];
        for (int i = 97,j=0; i <123 ; i++,j++) {
            chars[j]=(char)i;
        }
//        for (int i = 0; i <26 ; i++) {
//            core(i+1);
//        }
        core(1);

    }
    public static void core(int a){
        for (int i = 0; i <26; i++) {
            //第一个字母
            result = String.valueOf(chars[i]);
//            stringBuilder.append(s);
            //递归
            if(--a>0){
                core(a);
            }else {
                System.out.println(result);
            }
        }
    }
}
