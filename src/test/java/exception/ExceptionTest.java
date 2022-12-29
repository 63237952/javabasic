package exception;

public class ExceptionTest {
    public static void main(String[] args) {
        //使用try catch来处理异常，如果异常不处理，程序将终止
        //如果出现异常，try catch之后的程序正常执行
        try {
            int a=1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        int a=1/0;
        System.out.println("try catch 后的语句正常执行");
    }


}
