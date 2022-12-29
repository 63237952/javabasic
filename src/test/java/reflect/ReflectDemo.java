package reflect;

import IandOputStream.entity.Player;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
    /*
    * 使用反射获取class对象的方法
    * getDeclaredMethods() 获取所有方法
    * */
    @Test
    public void demo1(){
        try {
            //通过全限定类名来获取class对象
            Class c1 = Class.forName("IandOputStream.entity.Player");
            Method[] declaredMethods = c1.getDeclaredMethods();
            for (Method method:declaredMethods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
     * 使用反射获取class对象的方法
     * getMethods() 获取所有public修饰的方法（包括父类的public修饰方法）
     * */
    @Test
    public void demo2(){
        try {
            //通过全限定类名来获取class对象
            Class<Player> c = Player.class;
            Method[] methods = c.getMethods();
            for (Method method:methods) {
                System.out.println(method);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * 获取构造方法
    * */
    @Test
    public void demo3(){
        try {
            //通过全限定类名来获取class对象
            Class<Player> c = Player.class;
            Constructor[] constructors = c.getConstructors();
//            Constructor<Player> declaredConstructor = c.getDeclaredConstructor();
            for (Constructor constructor:constructors) {
                System.out.println(constructor);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * 获取class对象的成员变量
    * */
    @Test
    public void demo4(){
        try {
            //通过全限定类名来获取class对象
            Class<Player> c = Player.class;
            Field[] declaredFields = c.getDeclaredFields();
            Field[] fields = c.getFields();
            for (Field field:fields) {
                System.out.println(field);



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * 使用newInstance创建class对象的实例
     * */
    @Test
    public void demo5(){
        try {
            //通过全限定类名来获取class对象
            Class<Player> c = Player.class;
            //newInstance默认使用的是无参构造方法创建实例
            Player player = c.newInstance();
            System.out.println(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * 使用Constructor对象创建class对象的实例
     * */
    @Test
    public void demo6(){
        try {
            //通过全限定类名来获取class对象
            Class<Player> c = Player.class;
            //newInstance默认使用的是无参构造方法创建实例
            Constructor<Player> constructor = c.getConstructor();
            Player player = constructor.newInstance();
            System.out.println(player);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
