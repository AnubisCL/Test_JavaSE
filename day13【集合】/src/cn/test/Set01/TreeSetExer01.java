package cn.test.Set01;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExer01 {

    @Test
    public void test1() {
        TreeSet employees = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    //方式一：
                    /*int compareYear = b1.getYear() - b2.getYear();
                    if (compareYear!=0){
                        return compareYear;
                    }
                    int compareMonth = b1.getMonth() - b2.getMonth();
                    if (compareMonth!=0){
                        return compareMonth;
                    }
                    int compareDay = Integer.compare(b1.getDay(), b2.getDay());
                    if (compareDay!=0){
                        return compareDay;
                    } else {
                        return e1.compareTo(e2);
                    }*/
                    //方式二：
                    int compareDate = b1.compareTo(b2);
                    if (compareDate != 0) {
                        return compareDate;
                    }
                    return e1.compareTo(e2);
                } else {
                    throw new RuntimeException("输入日期类型不匹配！");
                }
            }
        });
        employees.add(new Employee("Jack", 23, new MyDate(1998, 01, 32)));
        employees.add(new Employee("Anubis", 22, new MyDate(1999, 03, 21)));
        employees.add(new Employee("Rabic", 20, new MyDate(2001, 11, 16)));
        employees.add(new Employee("Rabic", 20, new MyDate(2001, 11, 16)));
        employees.add(new Employee("Tom", 30, new MyDate(1980, 01, 01)));
        employees.add(new Employee("Xun", 21, new MyDate(2000, 05, 27)));

        Iterator iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
