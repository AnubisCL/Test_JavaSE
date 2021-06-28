package cn.test01.exerEnd.ShapeTest;

import org.junit.Test;

public class X5_3_6 {

    public static void main(String[] args) {
        Circle cir1 = new Circle(1);
        Circle cir2 = new Circle(2);
        System.out.println("area[cir1]:" + cir1.area());
        System.out.println("area[cir2]:" + cir2.area());
        System.out.println("perimeter[cir1]:" + cir1.perimeter());
        System.out.println("perimeter[cir2]:" + cir2.perimeter());
    }

    @Test
    public void test2() {

        Cylinder cyl1 = new Cylinder(1, 1);
        Cylinder cyl2 = new Cylinder(2, 2);
        System.out.println("area[cyl1]:" + cyl1.area());
        System.out.println("area[cyl2]:" + cyl2.area());
        System.out.println("volume[cyl1]:" + cyl1.volume());
        System.out.println("volume[cyl2]:" + cyl2.volume());
    }

    @Test
    public void test03() {
        /*Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，
        是否可以implements(实现)interface(接口)

        答：匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，
        但一个内部类可以作为一个接口，由另一个内部类实现.*/
        new Circle(new Shape() {
            @Override
            public double area() {
                return 0;
            }
        });

    }
}
