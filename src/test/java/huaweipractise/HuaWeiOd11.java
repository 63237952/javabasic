package huaweipractise;

import java.util.Scanner;
/*
* 知识点1：ip的正则表达式
* 知识点2：子网掩码的正则表达式
* 知识点3：char基本类型与int基本类型的转化，比如char‘1’转化为int时会变成48而不是1
* 还有Integer.valueOf(char "1")时结果是48 而不是1
* */
public class HuaWeiOd11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String yanma = in.nextLine();
            String ip_1 = in.nextLine();
            String ip_2 = in.nextLine();
            boolean yl=isYanmaLegal(yanma);
            boolean pl1=isIpLegal(ip_1);
            boolean pl2=isIpLegal(ip_2);

            //如果ip或者子网掩码不合法输出1
            if(!yl||!(pl1&&pl2)){
                System.out.println(1);
                continue;
            }else{
                //如果ip同一网络输出2,否则输出0
                // else if(yl){
                // if(pl1&&pl2){
                //将ip1字符串分割成4段0-255的字符串
                String[] ip1s=ip_1.split("\\.");
                String ip1_binary=getBinaryIpString(ip1s);
                System.out.println(ip1_binary+"ip1_binary");
                //将ip2字符串分割成4段0-255的字符串
                String[] ip2s=ip_2.split("\\.");
                String ip2_binary=getBinaryIpString(ip2s);
                System.out.println(ip2_binary+"ip2_binary");
                //将子网掩码字符串分割成4段0-255的字符串
                String[] yanmas=yanma.split("\\.");
                String yanma_binary=getBinaryIpString(yanmas);
                String result1=ipYanmaAndComputer(ip1_binary,yanma_binary);
                System.out.println(result1+"result1");
                String result2=ipYanmaAndComputer(ip2_binary,yanma_binary);
                System.out.println(result2+"result2");
                if(result1.equals(result2)){
                    System.out.println(0);
                }else{
                    System.out.println(2);
                }
                // }
                // }
            }
        }
    }
    public static String getBinaryIpString(String[] ip1s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ip1s.length;i++){
            //将4段0~255的字符串转化为8位二进制
            ip1s[i]=Integer.toBinaryString(Integer.valueOf(ip1s[i]));
            //八位二进制，不足八位前面补零
            switch(ip1s[i].length()){
                case 1:
                    ip1s[i]="0000000"+ip1s[i];
                    break;
                case 2:
                    ip1s[i]="000000"+ip1s[i];
                    break;
                case 3:
                    ip1s[i]="00000"+ip1s[i];
                    break;
                case 4:
                    ip1s[i]="0000"+ip1s[i];
                    break;
                case 5:
                    ip1s[i]="000"+ip1s[i];
                    break;
                case 6:
                    ip1s[i]="00"+ip1s[i];
                    break;
                case 7:
                    ip1s[i]="0"+ip1s[i];
                    break;
                case 8:
                    break;
            }
            sb.append(ip1s[i]);
        }
        String ip=sb.toString();
        return ip;
    }
    public static String ipYanmaAndComputer(String ip1_binary,String yanma_binary){
        char[] cpb=ip1_binary.toCharArray();
        char[] cyb=yanma_binary.toCharArray();
        char[] result=new char[cpb.length];
        for(int i=0;i<ip1_binary.length();i++){
            //按位进行与运算
            result[i]=String.valueOf((Integer.valueOf(String.valueOf(cpb[i]))&Integer.valueOf(String.valueOf(cyb[i])))).toCharArray()[0];
        }
        return String.valueOf(result);
    }
    //判断子网掩码的合法性
    public static boolean isYanmaLegal(String yanma){
        String[] ym=yanma.split("\\.");
        String yanma_binary=getBinaryIpString(ym);
        if(yanma_binary.matches("[1]+[0]+")){
            return true;
        }else{
            return false;
        }
    }
    //判断ip地址的合法性
    public static boolean isIpLegal(String ip){
        if(ip.matches("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}")){
            return true;
        }else{
            return false;
        }
    }

}
