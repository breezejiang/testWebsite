package main.java.com.weifeng.test;

public class TestTryCatchFinally {
    public static void main(String[] args) {
        int a = 1;
        try {
            a = a / 0;
        } catch (Exception e) {
            System.out.println("catch");
            return;// ��returnʱ��finally�е�����ִ�С�
            // System.exit(0);//��������䣬finally�е���䲻��ִ�С�ֱ�ӷ��أ��˳�����
        } finally // ��û��System.exit(0);ʱ�������Ƿ����쳣������ִ�С�
        {
            System.out.println("finally");
        }
    }
}
