package cn.test01;

class Window extends Thread{

    private static int tickets = 100;

    @Override
    public void run() {
        while (true){
            if (tickets>0){
                //放在：print() 中 -- 不重票是因为 print() 源码中自带线程锁
                /*System.out.println(Thread.currentThread().getName() +
                        ":卖票，票号为："+ --tickets);*/

                System.out.println(Thread.currentThread().getName() +
                        ":卖票，票号为："+ --tickets);
                tickets--;
            }else break;
        }
    }
}
public class WindowsTest {

    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}

