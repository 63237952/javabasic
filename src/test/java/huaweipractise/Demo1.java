package huaweipractise;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String wrong_word = in.nextLine();
            String ring_wordList = in.nextLine();
            String[] wrong_word_str = wrong_word.split(",");
            List<String> wrong_word_list = Arrays.asList(wrong_word_str);
            String[] right_wordList_str = ring_wordList.split(",");
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            for (int i = 0; i <wrong_word_str.length ; i++) {
                stringStringHashMap.put(wrong_word_str[i],"not found");
            }
            //条件1：变换位置后相等
            //记录以解决的错误单词下标
//            int[] record=new int[wrong_word_str.length];
//            int n=0;
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i <wrong_word_list.size(); i++) {
                //将每个单词转化为字符
                char[] wrong_word_chars = wrong_word_list.get(i).toCharArray();
                //排序
                Arrays.sort(wrong_word_chars);
                for (int j = 0; j <right_wordList_str.length ; j++) {
                    char[] right_wordList_chars = right_wordList_str[j].toCharArray();
                    Arrays.sort(right_wordList_chars);
                    if(String.valueOf(wrong_word_chars).equals(String.valueOf(right_wordList_chars))){
//                        result.add(right_wordList_str[j]);
                        stringStringHashMap.put(wrong_word_list.get(i),right_wordList_str[j]);
//                        record[n++]=i;
                    }
                }
            }
//            //移除掉已经找到单词库的单词
//            for (int i = 0; i <n; i++) {
//                wrong_word_list.remove(record[i]);
//            };
            //条件2：去重后相等

            for (int i = 0; i <wrong_word_list.size(); i++) {
                String str1 = quChong(wrong_word_list.get(i));
                for (int j = 0; j <right_wordList_str.length ; j++) {
                    String str2 = quChong(right_wordList_str[j]);
                    if(str1.equals(str2)){
//                        result.add(right_wordList_str[j]);
                        stringStringHashMap.put(wrong_word_list.get(i),right_wordList_str[j]);
                    }
                }
            }
            for (int i = 0; i <wrong_word_str.length ; i++) {
                if(i==wrong_word_str.length-1){
                    System.out.println(stringStringHashMap.get(wrong_word_str[i]));
                }else{
                    System.out.print(stringStringHashMap.get(wrong_word_str[i])+",");
                }
            }
        }
    }
    public static String quChong(String word){
        StringBuilder stringBuilder = new StringBuilder("");
        for (int j = 0; j <word.length(); j++) {
            String substring = String.valueOf(word.charAt(j));
            //如果不包含，则拼接
            if(!stringBuilder.toString().contains(substring)){
                stringBuilder.append(substring);
            }
        }
        return stringBuilder.toString();
}
}
