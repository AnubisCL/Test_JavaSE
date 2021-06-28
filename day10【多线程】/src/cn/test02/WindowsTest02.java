package cn.test02;


class Window2 extends Thread {

    private static int tickets = 100;

    private static Object object = new Object();

    @Override
    public void run() {
        while (true) {
            //synchronized (this){ 错误的 this代表 w1,w2,w3 三个对象
            //synchronized(Window2.class){ 对的 类只加载一次
            synchronized (object) {
                if (tickets > 0) {

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() +
                            ":卖票，票号为：" + tickets);
                    tickets--;
                } else break;
            }
        }
    }
}

public class WindowsTest02 {

    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}


