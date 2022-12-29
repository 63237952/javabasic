package huaweipractise;

import org.junit.Test;

import java.util.*;

public class TestCode3 {
    public static void main(String[] args) {
/*        Character[] characters = new Character[3];
        characters[0]='a';
        characters[1]='b';
        characters[2]='c';
        System.out.println();*/
//        List<Integer> list=new ArrayList<Integer>();
//        list.add(2);
//        list.add(4);
//        list.add(3);
//        list.add(1);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1>o2)
//                return 1;
//                else if(o1<o2)
//                    return -1;
//                return 0;
//            }
//        });
//        System.out.println(list);
//       int o= 3>>>1;
//        System.out.println(o);
//        String str="1234567890";
//        int i=(int)str.charAt(0);
//        System.out.println(i);
//        System.out.println(str.indexOf(48));
//        System.out.println(str.indexOf("8"));
//        String strrr="";
//        System.out.println(strrr.length());
//        List<Integer> list=new ArrayList<Integer>(4);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        System.out.println(list);
//        Arrays.copyOfRange();
//        LinkedList<Integer> list=new LinkedList<Integer>();
//        int[] ints = new int[4];
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
//        String ss="sdsaafa";
//        System.out.println(ss.contains("dsa"));
//        String s="delete";
//        String[] split = s.split(" ");
//        System.out.println(s.length());
//        for (String s1 : split) {
//            System.out.println(s1);
//        }
//        int[][] a=new int[3][4];
//        System.out.println(a.length);
//        System.out.println(a[0].length);
//        List list=new ArrayList<Integer>()
    }
    //练习随机数类
    @Test
    public void test1(){
        //返回double类型[0-1)范围的随机数
        System.out.println(Math.random());
        Random random = new Random();
        //返回[0,500)的整形随机数
        System.out.println(random.nextInt(500));
        System.out.println(random.nextFloat());
    }
    //ip地址的正则表达式

}
