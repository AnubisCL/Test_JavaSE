package cn.test01;

/**
 * 测试 Thread() 中的常用方法：
 * 1.start():启动当前线程，调用当前线程的 run() 方法
 * 2.run():通常需要重写 Thread 类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前 CPU 的执行权
 * 7.join():在线程 a 中调用线程 b 的 join() ,此时线程 a 就进入阻塞状态，直到线程 b 完全执行完以后，线程a才结束阻塞状态.
 * 8.stop():强制线程生命周期结束,不推荐使用,已过时。
 * 9.sleep(long millitime):让当前线程“睡眠”指定的 millitime 毫秒。在指定的 millitime 毫秒时间内,当前线程是阻塞状态。
 * 10.isAlive():返回 boolean ,判断线程是否还活着
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY: 10 -->
 * MIN_PRIORITY: 1 -->
 * NORM_PRIORITY: 5 --> 默认的优先级
 * 2.如何获取和设置当前线程的优先级：
 *   getPriority():获取线程的优先级
 *   setPriority():设置线程的优先级
 * 说明：高优先级的线程要抢占低优先级线程的cpu的执行权，但是只是从概率上讲，高优先级的线程
 */
public class ThreadMethodTest {
    public static void main(String[] args) {

        Thread1 th1 = new Thread1();

        th1.setName("线程1");
        th1.setPriority(Thread.MAX_PRIORITY);
        th1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + "[" +
                        Thread.currentThread().getPriority()+ "]:" + i);
            }
        }
    }
}


class Thread1 extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                /*try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName() + "[" +
                                   Thread.currentThread().getPriority()+ "]:" + i);
            }
        }
    }
}

class Thread2 extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                /*try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName() + "[" +
                        Thread.currentThread().getPriority()+ "]:" + i);
            }
        }
    }
}
