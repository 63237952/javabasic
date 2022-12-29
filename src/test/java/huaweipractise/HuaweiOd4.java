package huaweipractise;

import java.util.Scanner;

public class HuaweiOd4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //用于统计1出现的次数
        int n=0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            String str=Integer.toBinaryString(a);
            char[] chars=str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=="1".toCharArray()[0]){
                    n++;
                }
            }
            System.out.println(n);
            break;
        }
        in.close();
    }
}
