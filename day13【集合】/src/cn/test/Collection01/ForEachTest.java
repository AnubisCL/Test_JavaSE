package cn.test.Collection01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ForEachTest {

    @Test
    public void test1() {
        Collection list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(new String("asd"));
        list.add(false);    //包装类：Boolean
        list.add(new Person("Tom", 20));
        list.add(789);

        //内部仍然使用迭代器
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void test2(){
        int[] arr = {1,2,3,4,5};
        for (int i : arr) {
            System.out.println(i);
        }
    }


    //练习题1：（数组）
    @Test
    public void test3(){
        String arr[] = new String[]{"MM","MM","MM"};

        //方式一：输出 => GG
        /*for (int i = 0; i < arr.length; i++) {
            arr[i] = "GG";
        }*/

        //方式二：输出 => MM
        //结论：增强 for循环 不会改变原来数组的元素
        for (String s : arr) {
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
