package cn.test01.exerEnd;

public class InterfaceTest02 {
}
interface  A{
    int x = 0;
}
class B{
    int x =1;
}
class C extends B implements A {
    public void pX(){
        //Reference to 'x' is ambiguous, both 'B.x' and 'A.x' match
        //System.out.println(x);  //super.x   A.x
    }
    public static void main(String[] args) {
        new C().pX();
    }
}
