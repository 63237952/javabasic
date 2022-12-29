package huaweipractise;

import java.lang.reflect.Array;
import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String n=in.nextLine();
            List<Integer> messageSender=new ArrayList<Integer>();
            List<Integer> messageAccepter=new ArrayList<Integer>();
            for (int i = 0; i <Integer.valueOf(n)-1; i++) {
                String inputStr = in.nextLine();
                String[] split = inputStr.split(" ");
                messageSender.add(Integer.valueOf(split[0]));
                messageAccepter.add(Integer.valueOf(split[1]));
//                map.put(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
            }
            //需要判断sender是否为垃圾消息发送者
            int sender=Integer.valueOf(in.nextLine());
            boolean isLj=false;
            //sender发送消息的数量
            int sendMessages=0;
            for (int i = 0; i <messageSender.size() ; i++) {
                if (messageSender.get(i)==sender){
                    sendMessages++;
                }
            }
            //给sender发送过消息的数量
            int acceptMessages=0;
            for (int i = 0; i <messageAccepter.size() ; i++) {
                if (messageAccepter.get(i)==sender){
                    acceptMessages++;
                }
            }
            //M A发送的消息-A接收的消息>10
            if(sendMessages-acceptMessages>10){
                isLj=true;
            }
            //a 发送的消息的消息接受者中给a没有给a发送消息L
            ArrayList<Integer> a_Accepter = new ArrayList<>();
            for (int i = 0; i <messageSender.size() ; i++) {
                for (int j = 0; j <messageSender.size() ; j++) {
                    if(messageSender.get(i)==sender){
                        //a消息接收者集合
                        a_Accepter.add(messageSender.get(i));
                    }
                }
            }
            //A的接收者中给a发送消息的数量
            int L=0;
            for (int i = 0; i <a_Accepter.size(); i++) {
                for (int j = 0; j <messageSender.size(); j++) {
                    if(a_Accepter.get(i)==messageSender.get(j)){
                        if(messageAccepter.get(j)==sender){
                            L++;
                        }
                    }
                }
            }
            //A的接收者中没有给a发送消息的数量
            if(a_Accepter.size()-L>5){
                isLj=true;
            }
            //如果存在x 使得a发送x的消息-x发送给a的消息>5
//            for (int i = 0; i <; i++) {
//
//            }
            System.out.println(isLj+" "+(sendMessages-acceptMessages)+" "+(a_Accepter.size()-L));
        }
    }
}
