package IandOputStream;

import IandOputStream.entity.Player;
import org.junit.Test;

import java.io.*;

public class ObjectStream {
    /*
    * 序列化对象
    * */
    @Test
    public  void saveObject(){
        Player player = new Player();
        player.setAge(18);
        player.setHabby("basketball");
        player.setStature(180);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Play.txt"));
            objectOutputStream.writeObject(player);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    * 反序列化对象
    * */
    @Test
    public  void getObject(){
        Player player = null;
        ;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Play.txt"));
            Object o = objectInputStream.readObject();
            player = (Player) o;
            System.out.println(player);
            objectInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
