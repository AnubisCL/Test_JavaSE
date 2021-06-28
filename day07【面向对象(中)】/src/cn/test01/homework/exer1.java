package cn.test01.homework;

class Super {
    public int get() {
        return 4;
    }

    //重载：有不同的参数个数或有不同的参数类型
    /*public int get(int a){
        return 0;
    }*/

    //与上面函数不是重写、重载关系
   /* public long get() {
        return 5;
    }*/
}

class exer1 extends Super {
    //b.基本数据类型：子类（基本数据类型） == 父类（基本数据类型） == 相同类型
    /*public long get() {
        return 5;
    }*/

    public static void main(String[] args) {
        Super s = new exer1();
        System.out.println(s.get());
    }
}

