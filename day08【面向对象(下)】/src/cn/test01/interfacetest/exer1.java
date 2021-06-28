package cn.test01.interfacetest;

public class exer1 {
    public static void main(String[] args) {
        new C().pX();
    }
}

interface A {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A{
    public void pX(){
        //System.out.println(x);如果重名编译不通过
        System.out.println(super.x);    //父类B
        System.out.println(A.x);
    }
}