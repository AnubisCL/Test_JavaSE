package cn.test01.homework;

/*
0
* */
class A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

class B extends A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }
     //public int getA(){
     //return a;
     //}
}

public class AA {

    public static void main(String[] args) {
        A c = new B();

        c.setA(5);

        System.out.println(c.getA());

        B c1 = (B) c;

        System.out.println(c1.getA());
    }
}

