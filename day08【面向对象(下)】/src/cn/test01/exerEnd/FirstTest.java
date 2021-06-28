package cn.test01.exerEnd;

public class FirstTest {
    private int a;
    static int b = 5;

    public class Contents {
        public int c;

        //static int d;		//静态属性定义在非静态内部类中
        public int d;
        public void f() {
            System.out.println(new FirstTest().a);
            System.out.println(b);
        }
    }

    static class Titles {
        public int e;
        static int f;

        public void show() {
            //System.out.println(a);	//a为类的属性且为非静态不能调用
            System.out.println(b);
        }
    }

    public void getInnerClassDate() {
        //System.out.println(c);//c为非静态内部类的属性
        Contents contents = new Contents();
        System.out.println(contents.c);

        //System.out.println(d);//d不能定义,要使
        //同c

        //System.out.println(e);//静态内部类非静态属性
        Titles titles = new Titles();
        System.out.println(titles.e);

        //System.out.println(f);//静态内部类静态属性
        System.out.println(Titles.f);
    }

    /**
     * 2)在main方法中如何获得两个内部类的实例对象？并且访问内部类的方法，请写出代码
     * @param args
     */
    public static void main(String[] args) {
        FirstTest firstTest = new FirstTest();
        Contents contents = firstTest.new Contents();

        Titles titles = new Titles();

        titles.show();
        contents.f();

    }
}


