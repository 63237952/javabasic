package huaweipractise;
import java.util.*;
/*
* 输入描述：
﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~(2^31)-1，序列个数不限

输出描述：
﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：

I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。

按R<i>从小到大的顺序:

(1)先输出R<i>；

(2)再输出满足条件的I的个数；

(3)然后输出满足条件的I在I序列中的位置索引(从0开始)；

(4)最后再输出I。

附加条件：

(1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉

(2)如果没有满足条件的I，对应的R<i>不用输出

(3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)*/

//知识点的应用1：字符串的匹配regionMatches(int toffset, String other, int ooffset, int len),通过指定两个字符串的偏移量和长度
//比较两个字符串是否匹配
//知识点的应用2：字符串去除首尾空格的api方法trim()
public class HuaweiOd8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        // int[] ielements=new int[];
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String I = in.nextLine();
            String R = in.nextLine();
            String[] Is=I.split(" ");
            String[] Rs=R.split(" ");
            if(Is.length>=1&& Rs.length<=100){
                Set<Integer> set=new HashSet<Integer>();
                //先遍历Rs数组，将R序列去重排序
                for(int i=1;i<=Integer.valueOf(Rs[0]);i++){
                    //添加到集合中去重Integer.valueOf(Rs[i])
                    set.add(Integer.valueOf(Rs[i]));
                }
                //对Set集合进行排序
                List<Integer> list=new ArrayList<Integer>(set);
                Collections.sort(list);
                StringBuilder sb=new StringBuilder();
                //遍历Is 看I序列每一个元素是否包含list中的每一个元素
                for(int i=0;i<list.size();i++){

                    List<Integer> I_index=new ArrayList<Integer>();
                    List<Integer> I_element=new ArrayList<Integer>();

                    //如果I序列中的元素长度短于list中的元素的长度
                    for(int j=0;j<Integer.valueOf(Is[0]);j++){
                        //如果I序列中的元素长度短于list中的元素的长度,重新开始for循环
                        if(Is[j+1].length()<String.valueOf(list.get(i)).length()) continue;
                        else if(Is[j+1].length()==String.valueOf(list.get(i)).length()) {
                            boolean isMatch=Is[j+1].regionMatches(0,String.valueOf(list.get(i)),0,String.valueOf(list.get(i)).length());
                            //如果包含，则把I序列中的该元素和其下标保存到二维数组中
                            if(isMatch){
                                I_index.add(j);
                                I_element.add(Integer.valueOf(Is[j+1]));
                                continue;
                            }
                        }
                        else if(Is[j+1].length()>String.valueOf(list.get(i)).length()){
                            //遍历某个I序列的字符串元素是否包含r序列中的字符串
                            for(int k=0;k<=Is[j+1].length()-String.valueOf(list.get(i)).length();k++){
                                //循环判断是否包含list中的指定元素
                                boolean isMatch=Is[j+1].regionMatches(k,String.valueOf(list.get(i)),0,String.valueOf(list.get(i)).length());
                                if(isMatch){
                                    I_index.add(j);
                                    I_element.add(Integer.valueOf(Is[j+1]));
                                    break;
                                }
                            }
                        }
                    }
                    if(I_index.size()>=1){
                        if(i>=1){
                            sb.append(" "+String.valueOf(list.get(i))+" ");
                        }else{
                            sb.append(String.valueOf(list.get(i))+" ");
                        }
                        sb.append(I_index.size());
                        for(int l=0;l<I_index.size();l++){
                            sb.append(" "+I_index.get(l)+" "+I_element.get(l));
                        }
                    }

                }
                System.out.println(String.valueOf(sb.toString().trim().split(" ").length)+" "+sb.toString().trim());
            }

        }
    }
}
