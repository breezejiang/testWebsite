package main.java.com.weifeng.test;

public class TestOut {
    private String name = "out.name";

    void print() {
        final String work = "out.local.work";// ������final�����ܱ�Animal ʹ��.
        int age = 10;
        class Animal
        // ����һ���ֲ��ڲ���.ֻ����print()������ʹ��.
        // �ֲ����в���ʹ���ⲿ�ķ�final�ľֲ�����.ȫ�ֵĿ���.
        {
            public void eat() {
                System.out.println(work);// ok
                // age = 20;// error not final
                System.out.println(name);// ok.
            }
        }
        Animal local = new Animal();
        local.eat();
    }
}
