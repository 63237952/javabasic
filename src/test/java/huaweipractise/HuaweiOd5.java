package huaweipractise;

import java.util.Objects;
import java.util.Scanner;

public class HuaweiOd5 {
    static class Result{
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        int illegal=0;
        int private_=0;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Result result=new Result();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str=in.nextLine();
            //数组元素：ip，子网掩码
            String[] split= str.split("~");
            //分割ip
            String[] split_ip= split[0].split("\\.");
            //分割子网掩码
            String[] split_yanma=split[1].split("\\.");
            boolean illegalIp=false;
            //非法的ip，跳出循环，illegal计数+1
            for (int i = 0; i <4; i++) {
                try{
                    Integer.valueOf(split_ip[i]);
                }
                catch (Exception e){
                    result.illegal++;
                    illegalIp=true;
                    break;
                }
            }
            //非法ip跳出循环
            if(illegalIp){
                illegalIp=false;
                //跳出本次while循环
                continue;
            }
            if(isAtypeIP(split_ip)) {
                if(isLegalYanMa(split_yanma)){
                    result.a++;
                    if(isPrivateIp(split_ip)){
                        result.private_++;
                    }
                }else {
                    result.illegal++;
                }
            }
            else if (isBtypeIP(split_ip)) {
                if(isLegalYanMa(split_yanma)){
                    result.b++;
                    if(isPrivateIp(split_ip)){
                        result.private_++;
                    }
                }else {
                    result.illegal++;
                }
            }
            else if (isCtypeIP(split_ip))  {
                if(isLegalYanMa(split_yanma)){
                    result.c++;
                    if(isPrivateIp(split_ip)){
                        result.private_++;
                    }
                }else {
                    result.illegal++;
                }
            }
            else if (isDtypeIP(split_ip))  {
                if(isLegalYanMa(split_yanma)){
                    result.d++;
                    if(isPrivateIp(split_ip)){
                        result.private_++;
                    }
                }else {
                    result.illegal++;
                }
            }
            else if (isEtypeIP(split_ip)) {
                if(isLegalYanMa(split_yanma)){
                    result.e++;
                    if(isPrivateIp(split_ip)){
                        result.private_++;
                    }
                }else {
                    result.illegal++;
                }
            }
            System.out.println(result.a+" "+result.b+" "+result.c+" "+result.d+" "+result.e+" "+result.illegal+" "+result.private_);
        }

    }
    public static boolean isAtypeIP(String[] split_ip){
        boolean flag=false;
         if(Integer.valueOf(split_ip[0])>=1 && Integer.valueOf(split_ip[0])<=126){
        for(int i=1;i<split_ip.length;i++){
            if(Integer.valueOf(split_ip[i])<0 || Integer.valueOf(split_ip[i])>=255){
                flag=true;
                break;
            }
        }
        if (flag) {
            flag=false;
            return false;
        };
        return true;
         }
        return false;
    }
    public static boolean isBtypeIP(String[] split_ip){
        boolean flag=false;
         if(Integer.valueOf(split_ip[0])>=128 && Integer.valueOf(split_ip[0])<=191){
        for(int i=1;i<split_ip.length;i++){
            if(Integer.valueOf(split_ip[i])<0 || Integer.valueOf(split_ip[i])>=255){
                flag=true;
                break;
            }
        }
        if (flag) {
            flag=false;
            return false;
        };
        return true;
         }
        return false;
    }
    public static boolean isCtypeIP(String[] split_ip){
        boolean flag=false;
        if(Integer.valueOf(split_ip[0])>=192 && Integer.valueOf(split_ip[0])<=223){
            for(int i=1;i<split_ip.length;i++){
                if(Integer.valueOf(split_ip[i])<0 || Integer.valueOf(split_ip[i])>=255){
                    flag=true;
                    break;
                }
            }
            if (flag) {
                flag=false;
                return false;
            };
            return true;
        }
        return false;
    }
    public static boolean isDtypeIP(String[] split_ip){
        boolean flag=false;
        if(Integer.valueOf(split_ip[0])>=224 && Integer.valueOf(split_ip[0])<=239){
            for(int i=1;i<split_ip.length;i++){
                if(Integer.valueOf(split_ip[i])<0 || Integer.valueOf(split_ip[i])>=255){
                    flag=true;
                    break;
                }
            }
            if (flag) {
                flag=false;
                return false;
            };
            return true;
        }
        return false;
    }
    public static boolean isEtypeIP(String[] split_ip){
        boolean flag=false;
        if(Integer.valueOf(split_ip[0])>=240     && Integer.valueOf(split_ip[0])<=255){
            for(int i=1;i<split_ip.length;i++){
                if(Integer.valueOf(split_ip[i])<0 || Integer.valueOf(split_ip[i])>=255){
                    flag=true;
                    break;
                }
            }
            if (flag) {
                flag=false;
                return false;
            };
            return true;
        }
        return false;
    }
    public static boolean isLegalYanMa(String[] split_yanma){
/*        if(split_yanma[0].equals("255")){
        for (int i = 1; i <split_yanma.length; i++) {
//            String binary = Integer.toBinaryString(Integer.valueOf(split_yanma[i]));
            if(i==1){
                if(split_yanma[i].equals("255")||split_yanma[i].equals("0")){
                    continue;
                }else {
                    return false;
                }
            }
            if(i==2){
                if(split_yanma[i-1].equals("255")){
                   if (!split_yanma[i].equals("0")||!split_yanma[i].equals("255")){
                       return false;
                   }
                }else{
                    if(!split_yanma[i].equals("0")){
                        return false;
                    }
                }
            }
            if(i==3){
                if(!split_yanma[i].equals("0")) {
                    return false;
                }
            }
        }
            return true;
        }*/
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <split_yanma.length ; i++) {
            //将每一段的十进制转化为二进制
            String toBinaryString = Integer.toBinaryString(Integer.valueOf(split_yanma[i]));
            char[] chars = toBinaryString.toCharArray();
            int length = chars.length;
            switch (length){
                case 1:
                    toBinaryString = "0000000"+toBinaryString  ;
                    break;
                case 2:
                    toBinaryString = "000000"+ toBinaryString ;
                    break;
                case 3:
                    toBinaryString = "00000"+ toBinaryString ;
                    break;
                case 4:
                    toBinaryString = "0000"+ toBinaryString ;
                    break;
                case 5:
                    toBinaryString = "000"+ toBinaryString ;
                    break;
                case 6:
                    toBinaryString = "00"+ toBinaryString ;
                    break;
                case 7:
                    toBinaryString = "0"+ toBinaryString ;
                    break;
                case 8:
                    break;
                default:
                    return false;
            }
            //拼接二进制
            stringBuilder.append(toBinaryString);
        }
        //转化为字符串
        String yanma = stringBuilder.toString();
        System.out.println(yanma);
        //判断拼接起来的二进制是否符合前面是1，后面是0的正则表达式
        boolean matches = yanma.matches("[1]+[0]+");
        if(!matches){
            return false;
        }
        return true;
    }
    public static boolean isPrivateIp(String[] split){
        if(split[0].equals("10")){
            return true;
        }
        if(split[0].equals("172")){
            if(Integer.valueOf(split[1])>=16 &&Integer.valueOf(split[1])<=31){
                return true;
            }
        }
        if(split[0].equals("192") && split[1].equals("168")){
            return true;
        }
        return false;
    }
}


