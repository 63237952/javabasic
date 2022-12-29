package huaweipractise;

import java.util.*;

public class HuaweiOd9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();

            if(str.length()>=1&&str.length()<=1000){
                char[] c=str.toCharArray();
                Character[] cc=new Character[c.length];
                for (int i = 0; i <c.length ; i++) {
                    cc[i]=c[i];
                }
                Arrays.sort(cc, new Comparator<Character>() {
                            @Override
                            public int compare(Character c1, Character c2) {
                                if(((c1>=65&&c1<=90)||(c1>=97&&c1<=122))&&((c2>=65&&c2<=90)||(c2>=97&&c2<=122))){
                                    if((c1>=65&&c1<=90)&&(c2>=65&&c2<=90)){
                                        return c1-c2;
                                    }
                                    else if((c1>=65&&c1<=90)&&(c2>=97&&c2<=122)){
                                        if(c1+0==c2-32){
                                            return 0;
                                        }
                                        return c1-(c2-32);
                                    }
                                    else if((c1>=97&&c1<=122)&&(c2>=65&&c2<=90)){
                                        if(c1-32==c2+0){
                                            return 0;
                                        }
                                        return c1-32-c2;
                                    }
                                    else if((c1>=97&&c1<=122)&&(c2>=97&&c2<=122)){

                                        return c1-c2;
                                    }
                                }
                                return 0;
                            }
                        }  );
//                    if((c1>=65&&c1<=90)||(c1>=97&&c1<=122)){
//
//                    }
//                    return 0;
                for (Character character : cc) {
                    System.out.print(character.toString());
                }
//                char[] ccc=new char[cc.length];
//                for (int i = 0; i <cc.length ; i++) {
//                    ccc[i]=cc[i];
//                }
//                System.out.println(ccc);
            }

        }
 /*       Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = sort(str);
            System.out.println(res);
        }
    }
    public static String sort(String str) {
        // 先将英文字母收集起来
        List<Character> letters = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
        }
        // 将英文字母先排序好
        letters.sort(new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        // 若是非英文字母则直接添加
        System.out.println("sssss:"+letters);
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result.append(letters.get(j++));
            }
            else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();*/
    }
}