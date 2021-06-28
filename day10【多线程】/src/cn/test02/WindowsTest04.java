package cn.test02;

/**
 * 使用同步方法解决 继承 Thread 类的线程安全问题
 */
class Window4 extends Thread {

    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            buyTickets();
        }
    }


    private static synchronized void buyTickets() {    //同步监视器 是 (静态方法不能调this) Window4.class
        //private synchronized void buyTickets(){   //错误的 同步方法 的 同步监视器 是 this （w1,w2,w3）
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
    }
}

public class WindowsTest04 {

    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}


