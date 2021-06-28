package cn.test01.exerEnd.PersonTest;

public class Teacher extends Person{


    @Override
    public void work() {
        System.out.println("教书育人");
    }

    @Override
    public void hello() {
        System.out.println("同学号");
    }
}
