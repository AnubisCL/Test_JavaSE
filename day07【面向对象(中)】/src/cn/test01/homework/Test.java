package cn.test01.homework;

public class Test {

    public static void main(String[] args) {
        Base b1 = new Base();
        Base b2 = new Sub();
    }
}
class Base{
    Base(){
        method(100);
    }
    public void method(int i){
        System.out.println("base : " + i);
    }
}
class Sub extends Base{
    Sub(){
        super.method(70);
    }
    public void method(int j){
        System.out.println("sub : " + j);
    }
}

