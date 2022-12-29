package huaweipractise;

import java.util.Arrays;
import java.util.Scanner;

public class HuweiOd3 {
    public static void main(String[] args) {
/*
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            char[] c  =a.toCharArray();
            if(a.length()<=1000){
                for(int i=0;i<c.length;i++){
                    if(!Character.isLowerCase(c[i])){
                    continue;
                    }
                }

            }
        }
*/
    /*    Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if(str.length()>=1&&str.length()<=1000){
                if(!str.contains(" ")){
                    System.out.println(str);
                    break;
                }else{
                    String[] s1= str.split(" ");
                    for(int i=s1.length-1;i>=0;i--){
                        System.out.print(s1[i]+" ");
                    }
                    break;
                }

            }

        }*/
            //判断单词是否包含字符，如果包含的话，置为1，不包含为0；
            int flag=0;
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                String str = in.nextLine();
                Integer n=Integer.valueOf(str);
                if(n<1||n>1000){
                    continue;
                }
                String[] strs=new String[n];
                for(int i=0;i<n;i++){
                    while(in.hasNextLine()){
                        String el = in.nextLine();
                        if(el.length()<1||el.length()>100){
                            continue;
                        }
                        char[] chars = el.toCharArray();
                        for (int j = 0; j <chars.length ; j++) {
                            if(!Character.isLetter(chars[j])){
                                //中断当前的for循环
                                flag =1;
                                break;
                            }
                            }
                        //判断上一个for循环是正常退出，还是被中断了，如果是被中断了，跳出此次的while循环
                        if(flag==1){
                            flag=0;
                            //跳出当前的While循环
                            continue;
                        }
                        //赋值给字符串数组
                        strs[i]=el;
                        break;
                    }
                }
                Arrays.sort(strs,((o1, o2)->{
                    return o1.compareTo(o2);
                }));
                for(String result:strs){
                    System.out.println(result);
                }
                break;
            }
    }
}
