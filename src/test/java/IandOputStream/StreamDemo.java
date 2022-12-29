package IandOputStream;

import org.junit.Test;

import java.io.*;


public class StreamDemo {

    /*
    * 测试比较FileInputStream,FileOutputStream和BufferedInputStream,BufferedOutputStream的读写效率比较，通过测试比较
    * 缓冲流是普通流的3倍，前提是普通流得使用的Read（byte[] bytes）和Write（byte[] bytes）的方式，否者普通流的读写速度更慢
    * */

    @Test
    public  void test() {
        /*
        * 普通流使用Read（）和Write（）方法读写数据
        * */
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        int date;
        long start = System.currentTimeMillis();
        try {
            fileInputStream = new FileInputStream("C:\\Users\\lh\\Desktop\\IMG.jpg");
            fileOutputStream = new FileOutputStream("IMG.jpg");
            while((date=fileInputStream.read())!=-1){
                fileOutputStream.write(date);
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void test2() {
        /*
         * 普通流使用Read（byte[] bytes）和Write（byte[] bytes）方法读写数据
         * */
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        byte[] bytes=new byte[1024];
        long start = System.currentTimeMillis();
        try {
            fileInputStream = new FileInputStream("C:\\Users\\lh\\Desktop\\IMG.jpg");
            fileOutputStream = new FileOutputStream("IMG2.jpg");
            while((fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes);
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void test3() {
        /*
        * 缓冲流使用Read（byte[] bytes）和Write（byte[] bytes）方法读写数据
        * */
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        byte[] bytes=new byte[1024];
        long start = System.currentTimeMillis();
        try {
            fileInputStream = new FileInputStream("C:\\Users\\lh\\Desktop\\IMG.jpg");
            fileOutputStream = new FileOutputStream("IMG2.jpg");

            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            while((bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes);
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            bufferedOutputStream.close();
            bufferedInputStream.close();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
