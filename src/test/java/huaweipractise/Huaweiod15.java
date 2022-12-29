package huaweipractise;
import java.util.*;
public class Huaweiod15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            //加密的字符串
            String a = in.nextLine();
            //将字符串转化为字符数组
            char[] a_c=a.toCharArray();
            System.out.println(a_c[702]);
            //计算以每个字符有中心，其可能的有效字符串的最大长度
            //由于密码是左右对称的，所以计算下标1开始计算到小标为a.length-1
            int[] length=new int[a.length()];
            for(int i=0;i<a.length();i++){
                length[i]=1;
                for(int j=i+1,k=i-1;j<a.length()||k>=0;j++,k--){
                    try{
                        //多个字符对称
                        if(a_c[i]==a_c[k]){
                            if(a_c[j]==a_c[k-1]){
                                k--;
                                length[i]+=3;
                                continue;
                            }
                        }
                        if(a_c[i]==a_c[j]){
                            if(a_c[j+1]==a_c[k]){
                                j++;
                                length[i]+=3;
                                continue;
                            }
                        }
                        if(a_c[j]==a_c[k]){
                            length[i]+=2;
                            continue;
                        }else{
                            break;
                        }

                    }catch(Exception e){
                        break;
                    }
                    //单个字符为中心对称

                }
                // length[i]+=1;
            }
            int max=0;
            int index=0;
            for(int i:length){
                max=Math.max(i,max);
                System.out.println(i+"{"+index+"}");
                index++;
                //"{"+index+"}"+
            }
            System.out.println(max);
            System.out.println(Arrays.asList(length));
        }
    }
}
