package JUC.Demo_FunctionInterface;

import java.util.function.Consumer;

/*
* 消费型接口： Consumer<T>
*               void accept(T t);
*               传入一个参数，没有返回值
*   示例：使用消费型接口创建以你匿名内部类，传入一个字符串参数，实现打印功能
* */
public class DemoForConsumer {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        stringConsumer.accept("ni_hao");
    }
}
