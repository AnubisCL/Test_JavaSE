package cn.test01.exerEnd;

interface Test {
    void func();
}

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        // 补足代码；(匿名内部类)
//		new Demo().show(new Test() {
//			public void func() {
//
//			}
//		});
        /*Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，
        是否可以implements(实现)interface(接口)

        答：匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，
        但一个内部类可以作为一个接口，由另一个内部类实现.*/
        new AnonymousInnerClassTest().show(new Test() {
			public void func() {
                System.out.println("Anonymous Inner Class");
			}
		});

    }

    void show(Test t) {
        t.func();
    }
}
