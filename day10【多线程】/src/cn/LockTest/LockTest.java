package cn.LockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁  --- JDK5.0新增
 *
 * 1. 面试题：synchronized 与 Lock的异同？
 * 相同：二者都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 * Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 *
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 * 面试题：如何解决线程安全问题？有几种方式
 * 1. 同步代码块（synchronized{}）
 * 2. 同步方法（方法体加 synchronized）
 * 3. Lock 锁
 */

class WindowL implements Runnable {

    //1.实例化 ReentrantLock
    private ReentrantLock reentrantLock = new ReentrantLock(true);

    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            try {
                //2.调用加锁方法：lock()
                reentrantLock.lock();

                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() +
                            ":卖票，票号为：" + tickets);
                    tickets--;
                } else break;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //3.调用解锁方法：unlock()
                reentrantLock.unlock();
            }
        }
    }
}


public class LockTest {

    public static void main(String[] args) {
        WindowL w1 = new WindowL();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
