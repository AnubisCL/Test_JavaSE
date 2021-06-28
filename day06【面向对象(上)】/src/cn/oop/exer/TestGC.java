package cn.oop.exer;

public class TestGC {

    /*面试题：
        问：在程序中是否可以通知垃圾回收机制过来回收垃圾？
        答：能，通过调用System.gc();或Runtime.getRuntime().gc();

        再问：调用了System.gc();或Runtime.getRuntime().gc();后是立刻执行垃圾回收吗？
        答：不是，该调用并不会立刻启动垃圾回收机制开始回收，但会加快垃圾回收机制的运行。
*/
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            MyClass m = new MyClass(i+1);//这里本次循环完，本次创建的对象就成为垃圾了
            System.out.println("创建第" + (i + 1) + "的对象：" + m);
        }

        //通知垃圾回收机制来收集垃圾
        //System.gc();
        Runtime.getRuntime().gc();

        //为了延缓程序结束
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1);
            System.out.println("程序在继续....");
        }
    }
}

/*
* 构造器Constructor是否可被override
* 答：构造器Constructor不能被继承，因此不能重写Override，但可以被重载Overload
* */
class YouClass extends MyClass{

}

class MyClass {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyClass(int id) {
        this.id = id;
    }

    public MyClass() {
    }

    //这个方法是垃圾回收机制在回收它的对象时，自动调用，理解成对象留临终遗言的方法
    public void finalize() {
        System.out.println("轻轻的我走了....."+this.getId());
    }
}
