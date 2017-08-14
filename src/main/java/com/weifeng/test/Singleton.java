package main.java.com.weifeng.test;

public class Singleton {
    private volatile static Singleton singleton;

    // 第七种（双重校验锁）
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

    // // 第二种（懒汉，线程安全）：
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
