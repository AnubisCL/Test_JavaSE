package cn.oop.exer;

public class TestA {
    int i ;
    void change(int i){
        i++;
        System.out.println(i);  //（2）i=1
    }
    void change1(TestA t){
        t.i++;  //ta.i++
        System.out.println(t.i);    //（4）i=1
    }
    public static void main(String[] args) {
        TestA ta = new TestA();
        System.out.println(ta.i); //（1）i=0
        ta.change(ta.i);// （2）传形参
        System.out.println(ta.i); //（3）i=0
        ta.change1(ta);  // （4）形参
        System.out.println(ta.i);//i=1
    }
}

