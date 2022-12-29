package JUC.Demo_FunctionInterface;

import java.util.function.Function;

/*
* 函数型接口
* public interface Function<T, R>
* 接口中一个抽象方法
* R apply(T t)
* 泛型的作用是限定传入的参数和返回值
*
* 示例：使用函数式接口创建一个类，该类的功能是输出输入的值
* */
public class DemoForFunction {
    public static void main(String[] args) {
        //使用匿名内部类的方式创建了对象
        Function<String,String> function = new Function<String,String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };
        System.out.println(function.apply("你好"));
    }

}
