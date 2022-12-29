package huaweipractise;

import java.util.Arrays;
import java.util.Scanner;

public class HuaweiOd13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            //第一个参数：歌曲的数量
            String str1 = in.nextLine();
            //输入的指令
            String str2 = in.nextLine();
            //创建数组
            int[] a=new int[Integer.valueOf(str1)];
            // //创建长度为4的数组列表
            int[] b=new int[Integer.valueOf(str1)];
            int index_a=0;
            //给a数组赋值
            for(int i=0;i<a.length;i++){
                a[i]=i+1;
            }
            // //给b数组赋值
            // for(int i=1;i<=b.length;i++){
            //     b[i]=i;
            // }
            //数组复制
            b= Arrays.copyOfRange(a,0,4);
            //将指令转化字符
            char[] c=str2.toCharArray();
            for(int i=0;i<c.length;i++){
                if(c[i]=='U'){
                    if(index_a-1>=0){
                        index_a-=1;
                    }else{
                        int k=b[0];
                        if(k==1){
                            b=Arrays.copyOfRange(a,a.length-4,a.length);
                            index_a=3;
                        }else{
                            b=Arrays.copyOfRange(a,k-1,k-1+4);
                        }

                    }
                }
                if(c[i]=='D'){
                    if(index_a+1<=3){
                        index_a+=1;
                    }else{
                        int k=b[3];
                        if(k==Integer.valueOf(str1)){
                            b=Arrays.copyOfRange(a,0,4);
                            index_a=0;
                        }else{
                            b=Arrays.copyOfRange(a,k-4,k+1);
                        }

                    }
                }

            }
            System.out.println(b[0]+" "+b[1]+" "+b[2]+" "+b[3]);
            System.out.println(b[index_a]);
        }
    }
}
