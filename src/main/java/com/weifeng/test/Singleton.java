package main.java.com.weifeng.test;

public class Singleton {
    private volatile static Singleton singleton;

    // �����֣�˫��У������
    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    // private static Singleton instance;

    // // �ڶ��֣��������̰߳�ȫ����
    // private Singleton() {
    // }
    //
    // public static synchronized Singleton getInstance() {
    // if (instance == null) {
    // instance = new Singleton();
    // }
    // return instance;
    // }
}
