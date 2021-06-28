package cn.test01.homework;

public class PresonTest {

    public static void main(String[] args) {
        Person p1 = new Faculty();
        Person p2 = new Staff();

        //p1.setDegree("本科");
        //p2.duty = "职员";
        //不能调用子类所特有的方法、属性，编译时p1，p2都是Person类型
        /*有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法，
        但是由于变量声明为父类类型，编译时则只能调用父类的属性和方法，
        子类的属性和方法不能调用*/
        //使用强制类型转换
        //a instanceof AA:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
        if (p1 instanceof  Faculty){
            Faculty f1 = (Faculty) p1;
            f1.setDegree("本科");
        }
        if (p2 instanceof Staff){
            Staff s1 = (Staff) p2;
            ((Staff) p2).duty = "职员";
        }
        System.out.println();
    }
}

class Person{
    private String name;
    private String address;
    private String telphone;
    private String email;

    public Person() {
    }
}

class Employee extends Person{
    private String office;
    private double wage;
    private String hiredate;

    public Employee() {
    }
}

class Faculty extends Employee{
    public String degree;
    private String level;

    public Faculty() {
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Faculty(String degree) {
        this.degree = degree;
    }
}

class Staff extends Employee{
    public String duty;

    public Staff() {
    }

    public Staff(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
