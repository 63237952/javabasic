package huaweipractise;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Huaweiod16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            // Character[] c=new Character[a.length()];

            //分别存储运算符合表达式的栈对象
            Stack<Integer> number=new Stack<Integer>();
            Stack<Character> operator=new Stack<Character>();
            String temp="";
            boolean flag=true;
            for(int i=0;i<a.length();i++){
                if(flag){
                    if(a.charAt(i)=='('){
                        flag=false;
                        continue;
                    }
                    if(a.charAt(i)==')'){
                        if(temp!=""){
                            number.push(Integer.valueOf(temp));
                            temp="";
                        }
                        try{
                            do{
                                Integer second=number.pop();
                                Integer first=number.pop();
                                Character op=operator.pop();
                                if(op=='+'){
                                    number.push(first+second);
                                }
                                if(op=='-'){
                                    number.push(first-second);
                                }
                                if(op=='*'){
                                    number.push(first*second);
                                }
                                if(op=='/'){
                                    number.push(first/second);
                                }
                            }
                            while(operator.lastElement()=='*'||operator.lastElement()=='/');
                        }catch(Exception e){
                            flag=true;
                            continue;
                        }

                    }

                    if(Character.isDigit(a.charAt(i))){
                        if(i==a.length()-1){
                            temp+=String.valueOf(a.charAt(i));
                            number.push(Integer.valueOf(temp));
                            temp="";
                            continue;
                        }
                        temp+=String.valueOf(a.charAt(i));
                        continue;
                    }else{
                        if(temp!=""){
                            number.push(Integer.valueOf(temp));
                            temp="";
                        }
                        if(a.charAt(i)=='+'||a.charAt(i)=='-'||a.charAt(i)=='*'||a.charAt(i)=='/'){
                            if(a.charAt(i)=='+'||a.charAt(i)=='-'){
                                try{
                                    while(operator.lastElement()=='*'||operator.lastElement()=='/'){
                                        Integer second=number.pop();
                                        Integer first= number.pop();
                                        switch(operator.pop()){
                                            case '*':
                                                number.push(first*second);
                                                break;
                                            case '/':
                                                number.push(first/second);
                                                break;
                                        }
                                        // operator.push(a.charAt(i));
                                    }
                                    operator.push(a.charAt(i));

                                }catch(Exception e){
                                    operator.push(a.charAt(i));
                                    continue;
                                }
                            }else{
                                operator.push(a.charAt(i));
                            }
                        }
                    }
                }else{
                    if(a.charAt(i)=='('){
                        flag=false;
                        continue;
                    }
                    if(a.charAt(i)==')'){
                        if(temp!=""){
                            number.push(Integer.valueOf(temp));
                            temp="";
                        }
                        do{
                            Integer second=number.pop();
                            Integer first=number.pop();
                            Character op=operator.pop();
                            if(op=='+'){
                                number.push(first+second);
                            }
                            if(op=='-'){
                                number.push(first-second);
                            }
                            if(op=='*'){
                                number.push(first*second);
                            }
                            if(op=='/'){
                                number.push(first/second);
                            }
                        }
                        while(operator.lastElement()=='*'||operator.lastElement()=='/');
                        flag=true;
                        continue;
                    }
                    if(Character.isDigit(a.charAt(i))){
                        if(i==a.length()-1){
                            temp+=String.valueOf(a.charAt(i));
                            number.push(Integer.valueOf(temp));
                            temp="";
                            continue;
                        }
                        temp+=String.valueOf(a.charAt(i));
                        continue;
                    }else{
                        if(temp!=""){
                            number.push(Integer.valueOf(temp));
                            temp="";
                        }

                        operator.push(a.charAt(i));
                    }
                }

            }
            String ddd=cal(number,operator,number.pop());
            System.out.println(ddd);
        }
    }
    public static String cal(Stack<Integer> n,Stack<Character> o,int d){
        switch(o.pop()){
            case '*':
                d=n.pop()*d;
                break;
            case '/':
                d=n.pop()/d;
                break;
            case '+':
                d=n.pop()+d;
                break;
            case '-':
                d=n.pop()-d;
                break;
        }
        if(n.size()>0){
            return cal(n,o,d);
        }else{
            return String.valueOf(d);
        }
    }
}