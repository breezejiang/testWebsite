package main.java.com.weifeng.test.volatileAndSynchronizedTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public AtomicInteger inc = new AtomicInteger();

    public void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final AtomicIntegerTest test = new AtomicIntegerTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                };
            }.start();
        }

        while (Thread.activeCount() > 1) // ��֤ǰ����̶߳�ִ����
            Thread.yield();
        System.out.println(test.inc);
    }
}
