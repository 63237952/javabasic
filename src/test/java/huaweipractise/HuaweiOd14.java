package huaweipractise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuaweiOd14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,String> map=new HashMap<String,String>();
        String[] singleword=new String[1];
        String[][] multiple_word=new String[5][2];
        init(map,singleword,multiple_word);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            //a代表输入的指令
            String a = in.nextLine();
            if(a.contains(" ")){
                String[] a_split=a.split(" ");
                int count=0;
                String order="";
                for(int i=0,j=0;i<5;i++){
                    if(multiple_word[i][j].contains(a_split[0])){
                        if(multiple_word[i][j+1].contains(a_split[1])){
                            try{
                               if(multiple_word[i][j].substring(0,a_split[0].length()).contains(a_split[0])&&multiple_word[i][j+1].substring(0,a_split[1].length()).contains(a_split[1])) {
                                   order=multiple_word[i][0]+" "+multiple_word[i][1];
                                   count++;
//                                   System.out.println(count);
                               }
                            }catch(Exception e){
                                count--;
                            }
                        }
                    }
                }
                if(count==1){
                    System.out.println(map.get(order));
                }else{
                    System.out.println("unknown command");
                }
            }else{
                if(singleword[0].contains(a)){
                    System.out.println(map.get(singleword[0]));
                }else{
                    System.out.println("unknown command");
                }
            }

        }
    }
    public static void init(Map<String,String> map,String[] singleword,String[][] multiple_word){
        map.put("reset","reset what");
        map.put("reset board","board fault");
        map.put("board add","where to add");
        map.put("board delete","no board at all");
        map.put("reboot backplane","impossible");
        map.put("backplane abort","install first");
        singleword[0]="reset";
        multiple_word[0][0]="reset";
        multiple_word[0][1]="board";
        multiple_word[1][0]="board";
        multiple_word[1][1]="add";
        multiple_word[2][0]="board";
        multiple_word[2][1]="delete";
        multiple_word[3][0]="reboot";
        multiple_word[3][1]="backplane";
        multiple_word[4][0]="backplane";
        multiple_word[4][1]="abort";
    };
}
