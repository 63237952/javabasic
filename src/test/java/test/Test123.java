package test;

import IandOputStream.entity.Player;
import JUC.singletom.MyLazyMan;
import JUC.singletom.MySingleTom;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

public class Test123 {
    public static void main(String[] args) throws IOException {
        String s = UUID.randomUUID().toString();
        System.out.println(Runtime.getRuntime().availableProcessors());
        Integer a=1;
        Integer b=100;
        System.out.println(a.hashCode());
//        System.in.read();
        a.equals(b);
        System.out.println(a==b);
        Math.round(-1.5);
//        MySingleTom singleTom = MySingleTom.getSingleTom();
//        int a = MySingleTom.a;
//        MyLazyMan.getLazyMan();
//        int b1 = MyLazyMan.B;
//        MyLazyMan.getLazyMan1();
//        while (true){
//
//        }
        //怎么将数据以字节形式输出
        int f=1;
        Player player = new Player();
        player.setAge(1);
        player.setHabby("basketball");
        player.setStature(11);
        byte[] bytes = player.toString().getBytes();
        for (byte aByte : bytes) {
            System.out.print(aByte+" ");
        }


    }
}
