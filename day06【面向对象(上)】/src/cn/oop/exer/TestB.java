package cn.oop.exer;

/*
A.15 0 20
B.15 0 15
C.20 0 20
D.0 15 20
*/
//答案
/*
A is correct
*/




class Value{
    int i = 15;
}
class TestB{
    public static void main(String argv[]) {
        TestB t = new TestB();
        t.first();


    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.print(v.i + " " + i);
    }
}

