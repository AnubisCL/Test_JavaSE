package cn.test.Set01;

import java.util.Objects;

public class Employee implements Comparable {

    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            int compare = this.name.compareTo(e.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, e.age);
            }
        } else {
            throw new RuntimeException("输入类型不匹配！");
        }
    }
}

class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" + year + "年" + month + "月" + day + "日}";
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate myDate = (MyDate) o;
            int compareYear = this.getYear() - myDate.getYear();
            if (compareYear != 0) {
                return -compareYear;
            }
            int compareMonth = this.getMonth() - myDate.getMonth();
            if (compareMonth != 0) {
                return -compareMonth;
            }
            return -Integer.compare(this.getDay(), myDate.getDay());
        }
        throw new RuntimeException("输入类型不匹配！");

    }
}