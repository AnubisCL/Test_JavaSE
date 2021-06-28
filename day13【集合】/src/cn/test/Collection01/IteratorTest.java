package cn.test.Collection01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


//
public class IteratorTest {

    @Test
    public void test1() {
        Collection list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(new String("asd"));
        list.add(false);    //包装类：Boolean
        list.add(new Person("Tom", 20));
        list.add(789);

        Iterator iterator = list.iterator();
        //方式一：
        /*System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());*/
        //System.out.println(iterator.next());      //java.util.NoSuchElementException

        //方式二：
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(iterator.next());
        }*/

        //方式三：推荐
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(new String("asd"));
        list.add(false);    //包装类：Boolean
        list.add(new Person("Tom", 20));
        list.add(789);

        Iterator iterator = list.iterator();

        //删除集合中元素
        while (iterator.hasNext()) {
            if (iterator.next().equals("asd")) {
                iterator.remove();
            }
        }

        //未调用next()时，调用remove()会报错 IllegalStateExpection


        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}