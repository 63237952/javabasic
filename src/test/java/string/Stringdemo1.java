package string;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

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
    @Test
    public void demo10(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String sds = scanner.nextLine();
        String[] split = sds.split(" ");
        int length = split.length;
        System.out.println(split[length-1]);
    }

    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
        System.out.println("请输入字符串");
        String sds = scanner.nextLine();
        if(sds.length()>0&&sds.length()<5000){
        String[] split = sds.split(" ");
        int length = split.length;
        System.out.println(split[length-1].length());
        break;
        }
        }
    }
    */
/*        Scanner in = new Scanner(System.in);
        String str=null;
        String str2=null;
        int a=0;
        while(in.hasNextLine()){
            str=in.nextLine();
            if(str.length()<1){
                continue;
            }
            while(in.hasNextLine()){
                str2=in.nextLine();
                if(str2.length()==1){
                    break;
                }
            }
            for(int i=0;i<str.length();i++){
                char[] chars = str.toCharArray();
                if(str2.equalsIgnoreCase(String.valueOf(chars[i]))){
                    a++;
                }
            }
                System.out.println(a);
                break;
        }*/
/*        Scanner in = new Scanner(System.in);
//        double random = Math.random();
//        Random random1 = new Random();

//        Set set=new HashSet();
        Set<Integer> set  = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        Integer[] ints = new Integer[9];
        Integer[] integers = set.toArray(ints);
        //对数组进行升序排序
//        Arrays.sort(integers);
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer integer:
        integers) {
            System.out.println(integer);
        }
    }*/
      /*  Scanner in = new Scanner(System.in);

        int i1=0;
        String[] str;
        while(in.hasNextLine()){
            String s = in.nextLine();
            if(s==null||s.equals("")||s.length()>100){
                continue;
            }
            int length = s.length();
            int i = length % 8;
            if(i==0){
                if(length/8==0){
                    str=new String[1];
                }
                str=new String[length/8];
            }else {
               str=new String[length/8+1];
            }
            if(length/8>0){
            for (int j = 0; j < s.length()/8; j++) {

                String substring_= s.substring(j*8, j*8+8);
                str[i1]=substring_;
                i1++;
            }
            }
            switch(i){
                case 1:
                    String substring = s.substring((s.length()/8)*8);
                    String s1 = substring + "0000000";
                    str[i1]=s1;
                    break;
                case 2:
                    String substring2 = s.substring((s.length()/8)*8);
                    String s2 = substring2 + "000000";
                    str[i1]=s2;
                    break;
                case 3:
                    String substring3 = s.substring((s.length()/8)*8);
                    String s3 = substring3 + "00000";
                    str[i1]=s3;
                    break;
                case 4:
                    String substring4 = s.substring((s.length()/8)*8);
                    String s4 = substring4 + "0000";
                    str[i1]=s4;
                    break;
                case 5:
                    String substring5 = s.substring((s.length()/8)*8);
                    String s5 = substring5 + "000";
                    str[i1]=s5;
                    break;
                case 6:
                    String substring6 = s.substring((s.length()/8)*8);
                    String s6 = substring6 + "00";
                    str[i1]=s6;
                    break;
                case 7:
                    String substring7 = s.substring((s.length()/8)*8);
                    String s7 = substring7 + "0";
                    str[i1]=s7;
                    break;
                 default:
                     break;
            }
            for(String sss:str){
                System.out.println(sss);
            }
            break;

        }*/
/*        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String subString = str.substring(2);
            String s = subString.toUpperCase();
//            System.out.println(s);
            //返回十进制的整数，
            //参数一：进制的字符串表示形势，参数二：进制数
            //aa->170
            int b = Integer.parseInt(subString, 16);
            System.out.println(b);
            List<Integer> inter=new ArrayList<Integer>();
            break;
        }*/
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<Integer> inters=new ArrayList<Integer>();
        while(in.hasNextInt()){
            int a=in.nextInt();
            double sqrt = Math.sqrt(a);
            if(a>=1&&a<=Math.pow(10,9)*2+14){
                for(int i=2;i<=sqrt;i++){
                    //先算出a的因子
                    while(a%i==0){
                        a/=i;
                        inters.add(i);
                    }
                    if(a==1){
                        break;
                    }
                }
                if(a!=1){
                    inters.add(a);
                }
                for(Integer integer:inters){
                    System.out.print(integer+" ");
                }
            }
        }
    }
}
