package JUC.Demo_FunctionInterface;
//import com.sun.tools.javac.util.StringUtils;

import java.util.function.Predicate;

/*
* 断定型接口：Predicate<T>
*             boolean test(T t);
*     传入一个参数，返回布尔值
* 示例：创建一个匿名内部类，功能是判断一个字符串的值是否为空
*
* */
public class DemoForPredicate {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {

                return s.isEmpty();
            }
        };
        System.out.println(stringPredicate.test(""));
    }
}
