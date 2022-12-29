package reflect;

import IandOputStream.entity.IPlayer;
import IandOputStream.entity.Player;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy_Demo {
    public static void main(String[] args) {
        Player player_o = new Player();
        IPlayer player = (IPlayer)Proxy.newProxyInstance(Player.class.getClassLoader(), Player.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("getAge")){
                    int age = (int)method.invoke(player_o, args);
                    return age+1;
                }
                return method.invoke(player_o,args);
            }
        });
        System.out.println(player.getAge());
        System.out.println(player_o.getAge());
    }
}
