package JUC.Demo_Streanm;

import java.util.Arrays;
import java.util.List;

/*
* 题目要求：一分钟完成此题，并且只能一行代码
*现在有5个用户，筛选
* 1.ID为偶数
* 2.年龄大于23
* 3.用户名转为大写字母
* 4.用户名倒叙排序
* 5.只输出一个用户
*
*
* */
public class DemoForStream {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(6, "e", 25);

        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
        users.stream()
                .filter((u)->{return u.getId()%2==0;})
                .filter((u)->{return u.getAge()>23;})
                .map((u)->{return u.getName().toUpperCase();})
                .sorted((u11,u22)->{return u22.compareTo(u11);})
                .forEach(System.out::println);

    }
}
class User{
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}