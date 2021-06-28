package cn.test01.wrapper1;

import org.junit.Test;

public class InterviewTest {

    @Test
    public void test1() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(01);     //1.0
        //三元运算符 也要自动类型提升
    }

    @Test
    public void test2() {
        Object o2;
        if (true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.println(o2);     //1
    }

    @Test
    public void test3() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);       //false比较对象的地址值

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);     //true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);     //false

        /*
        Integer中定义了 IntegerCache 的结构：
        IntegerCache 中定义的属性有：
        int low = -128;
        int high；
        Integer cache[];
        存储 [-128,+127] 之间的数(这个范围的数用的比较频繁,因此提前加载好了)
        当使用这个范围的数时直接调用，不需要重新 new 对象 ,
        当使用超过这个范围的数时，则用一个就造一个对象。

        因此超出 127 时两个的对象地址值不同，输出 false


        */
    }
}
