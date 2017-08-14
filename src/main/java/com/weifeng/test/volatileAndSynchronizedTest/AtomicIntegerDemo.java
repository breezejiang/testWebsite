package main.java.com.weifeng.test.volatileAndSynchronizedTest;

import java.util.concurrent.atomic.AtomicInteger;

//1.原子性
//
//在Java中，对基本数据类型的变量的读取和赋值操作是原子性操作，即这些操作是不可被中断的，要么执行，要么不执行。
//
//上面一句话虽然看起来简单，但是理解起来并不是那么容易。看下面一个例子i：
//
//请分析以下哪些操作是原子性操作：
//
//1
//2
//3
//4
//x = 10;         //语句1
//y = x;         //语句2
//x++;           //语句3
//x = x + 1;     //语句4
//　咋一看，有些朋友可能会说上面的4个语句中的操作都是原子性操作。其实只有语句1是原子性操作，其他三个语句都不是原子性操作。
//
//语句1是直接将数值10赋值给x，也就是说线程执行这个语句的会直接将数值10写入到工作内存中。
//
//语句2实际上包含2个操作，它先要去读取x的值，再将x的值写入工作内存，虽然读取x的值以及 将x的值写入工作内存 这2个操作都是原子性操作，但是合起来就不是原子性操作了。
//
//同样的，x++和 x = x+1包括3个操作：读取x的值，进行加1操作，写入新的值。
//
//　所以上面4个语句只有语句1的操作具备原子性。
//
//也就是说，只有简单的读取、赋值（而且必须是将数字赋值给某个变量，变量之间的相互赋值不是原子操作）才是原子操作。
//
//不过这里有一点需要注意：在32位平台下，对64位数据的读取和赋值是需要通过两个操作来完成的，不能保证其原子性。但是好像在最新的JDK中，JVM已经保证对64位数据的读取和赋值也是原子性操作了。
//
//从上面可以看出，Java内存模型只保证了基本读取和赋值是原子性操作，如果要实现更大范围操作的原子性，可以通过synchronized和Lock来实现。由于synchronized和Lock能够保证任一时刻只有一个线程执行该代码块，那么自然就不存在原子性问题了，从而保证了原子性。
//
//2.可见性
//
//对于可见性，Java提供了volatile关键字来保证可见性。
//
//当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
//
//而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的，当其他线程去读取时，此时内存中可能还是原来的旧值，因此无法保证可见性。
//
//另外，通过synchronized和Lock也能够保证可见性，synchronized和Lock能保证同一时刻只有一个线程获取锁然后执行同步代码，并且在释放锁之前会将对变量的修改刷新到主存当中。因此可以保证可见性。
//
//3.有序性
//
//在Java内存模型中，允许编译器和处理器对指令进行重排序，但是重排序过程不会影响到单线程程序的执行，却会影响到多线程并发执行的正确性。
//
//在Java里面，可以通过volatile关键字来保证一定的“有序性”（具体原理在下一节讲述）。另外可以通过synchronized和Lock来保证有序性，很显然，synchronized和Lock保证每个时刻是有一个线程执行同步代码，相当于是让线程顺序执行同步代码，自然就保证了有序性。
//
//另外，Java内存模型具备一些先天的“有序性”，即不需要通过任何手段就能够得到保证的有序性，这个通常也称为 happens-before 原则。如果两个操作的执行次序无法从happens-before原则推导出来，那么它们就不能保证它们的有序性，虚拟机可以随意地对它们进行重排序。

/**
 * 来看AtomicInteger提供的接口。 //获取当前的值 public final int get() //取当前的值，并设置新的值 public final int getAndSet(int newValue) //获取当前的值，并自增 public final int
 * getAndIncrement() //获取当前的值，并自减 public final int getAndDecrement() //获取当前的值，并加上预期的值 public final int getAndAdd(int delta)
 * 
 * @author YangBaoBao
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        int i1 = ai.get();
        v(i1);
        int i2 = ai.getAndSet(5);
        v(i2);
        int i3 = ai.get();
        v(i3);
        int i4 = ai.getAndIncrement();
        v(i4);
        v(ai.get());

    }

    static void v(int i) {
        System.out.println("i : " + i);
    }
}
