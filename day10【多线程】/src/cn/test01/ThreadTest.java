package cn.test01;

/**
 * 多线程的创建：
 * 方式一：
 * 1.创建一个继承于Thread的子类
 * 2.重写Thread类的run()方法 --> 针对于方法体
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()方法
 * <p>
 * 例子：遍历100以内的所有的偶数
 */
public class ThreadTest extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        //通过此对象调用start()：1.启动当前线程 2.调当前线程的run()
        threadTest.start();
        //threadTest.run();   //还是主线程执行，知识调用 ThreadTest() 类的 run() 方法

        ThreadTest threadTest1 = new ThreadTest();
        threadTest1.start();

        //如下操作扔是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}
