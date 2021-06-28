package cn.test01;

class WindowsRun implements Runnable {

    public /*static*/ int tickes = 10;

    @Override
    public void run() {
        while (true) {
            if (tickes>0){
                System.out.println(Thread.currentThread().getName() + ": 买票，票号为："+ tickes);
                tickes--;
            } else break;
        }
    }
}

public class WindowsRunableTest1 {

    public static void main(String[] args) {
        WindowsRun w1 = new WindowsRun();
        Thread t1 = new Thread(w1);
        t1.setName("窗口1");
        t1.start();

        Thread t2 = new Thread(w1);
        t2.setName("窗口2");
        t2.start();

        Thread t3 = new Thread(w1);
        t3.setName("窗口3");
        t3.start();

    }

}