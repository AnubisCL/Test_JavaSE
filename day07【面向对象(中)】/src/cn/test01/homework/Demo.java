package cn.test01.homework;

/*
* A
* B
* */
class Fu {
    boolean show(char a) {
        System.out.println(a);
        return true;
    }
}

public class Demo extends Fu {
    public static void main(String[] args) {
        int i = 0;
        Fu f = new Demo();
        Demo d = new Demo();
        //      false           false                       false
        for (f.show('A'); f.show('B') && (i < 2); f.show('C')) {
            i++;
            d.show('D');
        }
    }

    boolean show(char a) {
        System.out.println(a);
        return false;
    }
}

