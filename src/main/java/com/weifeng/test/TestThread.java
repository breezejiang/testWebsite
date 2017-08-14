package main.java.com.weifeng.test;

public class TestThread {
    static public synchronized void main(String[] args) {
        // 1
        ThreadClass1 t1 = new ThreadClass1();
        t1.start();
        System.out.println("end1");// �����end��

        ThreadClass2 t = new ThreadClass2();
        Thread thread = new Thread(t);
        thread.start();
        System.out.println("end2");
    }

}

// Thread���Ѿ�ʵ���˿յ�run()������
class ThreadClass1 extends Thread {
}

class ThreadClass2 implements Runnable {
    // �����д˷���������뱨������Runnable�ӿ��еĳ��󷽷���
    public void run() {
        System.out.println("Threads");
    }
}
