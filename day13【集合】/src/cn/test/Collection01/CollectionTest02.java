package cn.test.Collection01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest02 {

    public static void main(String[] args) {

        Collection list = new ArrayList();

        //1.add() 添加 返回 Boolean
        list.add(123);
        list.add(456);
        list.add(new String("asd"));
        list.add(false);    //包装类：Boolean
        list.add(new Person("Tom", 20));
        list.add(789);

        //2.contains(？) 当前集合是否存在？比较 返回 Boolean
        System.out.println(list.contains(new String("asd")));
        System.out.println(list.contains(new Person("Tom", 20)));

        Collection coll = Arrays.asList(123, 789);
        //3.containsAll() 当前集合是否存在？比较 返回 Boolean
        System.out.println(list.containsAll(coll));

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

        System.out.println(list);
        //4.remove() 移除
        //boolean b = list.remove(456);
        Collection coll = Arrays.asList(456, false);
        //5.removeAll() 移除
        boolean b = list.removeAll(coll);
        System.out.println(list + " " + b);

    }

    @Test
    public void test3() {
        Collection list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(new String("asd"));
        list.add(false);    //包装类：Boolean
        list.add(new Person("Tom", 20));
        list.add(789);

        Collection coll = Arrays.asList(123,456,789);
        //6.retainAll(): 交集：获取当前集合和coll集合的交集，并返回给当前集合
        boolean b = list.retainAll(coll);
        System.out.println(list);

    }

    @Test
    public void test4() {
        Collection list1 = new ArrayList();

        list1.add(123);
        list1.add(456);
        list1.add(new String("asd"));
        list1.add(false);    //包装类：Boolean
        list1.add(new Person("Tom", 20));
        list1.add(789);

        Collection list2 = new ArrayList();

        list2.add(456);
        list2.add(123);
        list2.add(new String("asd"));
        list2.add(false);    //包装类：Boolean
        list2.add(new Person("Tom", 20));
        list2.add(789);

        //ArrayList() 是有序的 则返回 false
        //7.equals() 需要当前集合和形参集合的元素都相同
        System.out.println(list1.equals(list2));

    }

    @Test
    public void test5() {
        Collection list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(new String("asd"));
        list.add(false);    //包装类：Boolean
        list.add(new Person("Tom", 20));
        list.add(789);

        //8.hashCode() 返回当前对象哈希值
        System.out.println(list.hashCode());

        System.out.println("------------------");
        //9.toArray() 集合 => 数组
        Object[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("------------------");

        //10.Arrays.asList() 数组 => 集合 (泛型)
        List<String> stringList = Arrays.asList(new String[]{"AA", "bb", "CC"});
        System.out.println(stringList);

        System.out.println("------------------");

        //注意：使用包装类
        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints.size());    //1

        List ints2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(ints2.size());   //2

    }
}

