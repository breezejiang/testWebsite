package main.java.com.weifeng.test;

public class TestThread {
    static public synchronized void main(String[] args) {
        // 1
        ThreadClass1 t1 = new ThreadClass1();
        t1.start();
        System.out.println("end1");// 输出“end”

        ThreadClass2 t = new ThreadClass2();
        Thread thread = new Thread(t);
        thread.start();
        System.out.println("end2");
    }

}

// Thread类已经实现了空的run()方法。
class ThreadClass1 extends Thread {
}

class ThreadClass2 implements Runnable {
    // 必须有此方法否则编译报错。它是Runnable接口中的抽象方法。
    public void run() {
        System.out.println("Threads");
    }
}
