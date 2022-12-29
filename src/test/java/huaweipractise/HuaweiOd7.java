package huaweipractise;

import java.util.Scanner;

public class HuaweiOd7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isRepeat=false;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] chars=new char[str.length()];
            if(str.length()>=1&&str.length()<=100){
                if(str.matches("[\\S]{8,}")){
                    int length=str.length();
                    int A=0;
                    int B=0;
                    int C=0;
                    int D=0;
                    for(int i=0;i<length;i++){
                        String split=str.substring(i,i+1);
                        char c=split.charAt(0);
                        isRepeat=isRepeat(chars,str,i);
                        if(isRepeat){
                            break;
                        }
                        chars[i]=c;
                        int c_int=(int)c;
                        if(c>=48&&c<=57) {
                            A++;
                            continue;
                        }
                        else if(c>=65&&c<=90){
                            B++;
                            continue;
                        }
                        else if(c>=97&&c<=122){
                            C++;
                            continue;
                        }
                        else if((c>=0&&c<48)||(c>57&&c<65)||(c>90&&c<97)||(c>122&&c<=255)){
                            D++;
                            continue;
                        }
                    }
                    if((A>=1&&B>=1&&C>=1)||(A>=1&&B>=1&&D>=1)||(A>=1&&C>=1&&D>=1)||(B>=1&&C>=1&&D>=1)){
                        if(isRepeat){
                            System.out.println("NG");
                            return;
                        }
                        System.out.println("OK");
                    }else{
                        System.out.println("NG");
                    }
                }else{
                    System.out.println("NG");
                }
            }

        }
    }
    public static boolean isRepeat(char[] chars,String str,int i){
        for(int j=0;j<i;j++){

            if(chars[j]==str.substring(i,i+1).toCharArray()[0] && j+2<i &&i+2<str.length()){
                char[] charss=new char[3];
                charss[0]=chars[j];
                charss[1]=chars[j+1];
                charss[2]=chars[j+2];
                String sss=String.valueOf(charss);
                String substring = str.substring(i, i + 3);
                if(sss.equals(substring)){
                    return true;
                }
            }
        }
        return false;
    }
}
