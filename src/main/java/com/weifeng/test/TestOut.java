package main.java.com.weifeng.test;

public class TestOut {
    private String name = "out.name";

    void print() {
        final String work = "out.local.work";// 若不是final的则不能被Animal 使用.
        int age = 10;
        class Animal
        // 定义一个局部内部类.只能在print()方法中使用.
        // 局部类中不能使用外部的非final的局部变量.全局的可以.
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
