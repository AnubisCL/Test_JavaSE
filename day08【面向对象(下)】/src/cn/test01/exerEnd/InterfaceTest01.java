package cn.test01.exerEnd;

interface Inter {
    void show(int a, int b);

    void func();
}

public class InterfaceTest01 {
    public static void main(String[] args) {
        // 补足代码；调用两个函数，要求用匿名内部类
        Inter in = new Inter() {
            public void show(int a, int b) {
                System.out.println("{a:" + a + ", b:" + b + "}");
            }

            public void func() {
                System.out.println("===========Over=============");
            }
        };

        in.show(4, 5);
        in.func();

    }
}
