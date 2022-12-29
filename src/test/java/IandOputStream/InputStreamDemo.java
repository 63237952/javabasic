package IandOputStream;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

public class InputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        String str = new String("我爱中国AAA");
        byte[] bytes = str.getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        FileInputStream fileInputStream = new FileInputStream("abc.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("bbb.txt");
    }
}
