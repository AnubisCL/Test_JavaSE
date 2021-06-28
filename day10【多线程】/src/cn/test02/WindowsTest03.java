package cn.test02;

/**
 * 使用同步方法解决实现 Runnable 接口的线程安全问题
 */
class Window3 implements Runnable {

    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            buyTickets();
        }
    }

    //同步方法 的 同步监视器 是 this
    private synchronized void buyTickets(){
        //synchronized (this) {
            if (tickets > 0) {
                //增大线程同时判断if语句
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() +
                        ":卖票，票号为：" + tickets);
                tickets--;
            }
        //}
    }
}

public class WindowsTest03 {

    public static void main(String[] args) {
        Window3 w1 = new Window3();

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
