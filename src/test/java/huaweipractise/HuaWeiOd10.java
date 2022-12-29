package huaweipractise;

import java.util.*;
/*
* 描述
定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
注意：字典中可能有重复单词。

数据范围：1 \le n \le 1000 \1≤n≤1000 ，输入的字符串长度满足 1 \le len(str) \le 10 \1≤len(str)≤10  ， 1 \le k < n \1≤k<n
输入描述：
输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k
输出描述：
第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
示例1
输入：
3 abc bca cab abc 1
输出：
2
bca
示例2
输入：
6 cab ad abcd cba abc bca abc 1
输出：
3
bca
说明：
abc的兄弟单词有cab cba bca，所以输出3
经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca         */
public class HuaWeiOd10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if(a>=1&&a<=1000){
                List<String> list=new ArrayList<String>();
                for(int i=0;i<a;i++){
                    //添加单词到集合中
                    list.add(in.next());
                }
                //待查找的单词
                String word=in.next();
                // System.out.println(word);
                //第k个单词
                int index=in.nextInt();
                if(index<1||index>a){
                    //重新开始while循环
                    continue;
                }
                //arraylist存储兄弟字符串
                List<String> brother_list=new ArrayList<String>();
                for(int j=0;j<list.size();j++){
                    //遍历每一个单词
                    String word_list=list.get(j);
                    //与指定的单词做比较
                    //两个单词成立的条件是：两个单词不相等
                    //两个单词排序后相等
                    if(word.length()==word_list.length()&&!word.equals(word_list)){
                        //将word和word_list都转化为字符串
                        char[] ca=word.toCharArray();
                        String sa=transferToString(ca);
                        char[] cb=word_list.toCharArray();
                        String sb=transferToString(cb);
                        if(sa.equals(sb)){
                            brother_list.add(word_list);
                        }
                    }

                }
                //遍历结束后，对brother_list集合按字典排序
                Collections.sort(brother_list,(String o1,String o2)->{
                    return o1.compareTo(o2);
                });

                System.out.println(brother_list.size());
                //指定要查找的第k个单词要小于brother_list的长度，这个单词才存在与brother_list中
                if(index<=brother_list.size()){
                    System.out.println(brother_list.get(index-1));
                }
            }
        }
    }
    public static String transferToString(char[] ca){
        //将char[]数组转化为包装类Character[]数组
        Character[] ca_=new Character[ca.length];
        for(int i=0;i<ca.length;i++){
            ca_[i]=ca[i];
        }
        //再将包装类转化为List集合
        List<Character> la= Arrays.asList(ca_);
        //对charactor数组进行按字典排序
        Collections.sort(la,(Character n, Character m)->{
            return n.charValue()-m.charValue();
        });
        //排完序转化为字符串输出
        for(int i=0;i<la.size();i++){
            ca[i]=la.get(i);
        }
        String sa=String.valueOf(ca);
        return sa;
    }
}