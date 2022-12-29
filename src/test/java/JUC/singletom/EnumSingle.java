package JUC.singletom;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/*
* 无法使用反射破坏枚举，所以单例模式应该用枚举来创建
* 枚举来创建单例是线程安全的，无法通过反射来破坏的
*
* */
public enum EnumSingle {
    //枚举类EnumSingle的示例类初始化时会在静态代码块中创建EnumSingle INSTANCE=new EnumSingle();
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    };
}
class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle instance = EnumSingle.INSTANCE;
        EnumSingle instance1 = EnumSingle.INSTANCE;
        System.out.println(instance);
        System.out.println(instance1);

        Class<EnumSingle> enumSingleClass = EnumSingle.class;
        Constructor<EnumSingle> declaredConstructor = enumSingleClass.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle = declaredConstructor.newInstance("ss",1);
        EnumSingle enumSingle1 = declaredConstructor.newInstance("sss",2);
        System.out.println(enumSingle);
        System.out.println(enumSingle1);
    }
}