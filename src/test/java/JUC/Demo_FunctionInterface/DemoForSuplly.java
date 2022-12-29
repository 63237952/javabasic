package JUC.Demo_FunctionInterface;

import java.util.function.Supplier;

/*
* 供给型接口：Supplier<T>
*              T get()
*              没有参数，有返回值，泛型类型就是返回值
 * */
public class DemoForSuplly {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "abc";
            }
        };
        System.out.println(stringSupplier.get());
    }
}
