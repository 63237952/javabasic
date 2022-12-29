package huaweipractise;

import java.util.Scanner;

public class TestCode2 {
    public static void main(String[] args) {
      /*  Scanner in = new Scanner(System.in);
        int x=0;
        int y=0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            if(str.length()>=0 && str.length()<=10000){
                String[] str1=str.split(";");
                for(int i=0;i<str1.length;i++){
                    System.out.println(i);
                    if(str1[i].length()==0){
                        continue;
                    }
                    String statu=str1[i].substring(0,1);
                    if("A".equals(statu)||"D".equals(statu)||"W".equals(statu)||"S".equals(statu)){
                        String str2=str1[i].substring(1);
                        int k=0;
                        try{
                            k =Integer.valueOf(str2);
                        }catch(Exception e){
                            continue;
                        };
                        if(statu.equals("A")){
                            x-=k;
                        }
                        if(statu.equals("D")){
                            x+=k;
                        }
                        if(statu.equals("W")){
                            y+=k;
                        }
                        if(statu.equals("S")){
                            y-=k;
                        }
                    }
                }
                System.out.print(x+","+y);
                break;
            }
        }*/
        Scanner in = new Scanner(System.in);
        Result result=new Result();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str=in.nextLine();


        }
    }
    static class Result{
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        int illegal=0;
        int private_=0;

    }
}
