package main.java.com.weifeng.test;

public class TestTryCatchFinally {
    public static void main(String[] args) {
        int a = 1;
        try {
            a = a / 0;
        } catch (Exception e) {
            System.out.println("catch");
            return;// 当return时，finally中的语句会执行。
            // System.exit(0);//若用上这句，finally中的语句不会执行。直接返回，退出程序。
        } finally // 当没有System.exit(0);时，无论是否发生异常它都会执行。
        {
            System.out.println("finally");
        }
    }
}
