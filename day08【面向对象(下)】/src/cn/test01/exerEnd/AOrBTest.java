package cn.test01.exerEnd;

public class AOrBTest {

    public static void main(String[] args) {
        AOrBTest aOrBTest = new AOrBTest();
        A a = aOrBTest.new A();
        A.B b = a.new B();
        b.show();

    }

    class A {
        public A() {
        }

        class B {
            public static final String name = "BBAB";

            public void show() {
                System.out.println("name:" + name);
            }
        }
    }
}

