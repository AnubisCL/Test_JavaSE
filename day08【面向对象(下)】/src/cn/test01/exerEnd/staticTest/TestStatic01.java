package cn.test01.exerEnd.staticTest;

public class TestStatic01 {
        static int x, y, z;

        static {
            int x = 5;
            x--;
        }

        static {
            x--;
        }
        //reference
        public static void main(String[] args) {
            System.out.println("x=" + x);
            z--; //-1
            method();
            System.out.println("result:" + (z + y + ++z));      //括号运算结束z+1 so 等于 3
            /*
            x=-1
            result:3*/
        }

        public static void method() {
            y = z++ + ++z; //y= 0 + 0 = 0 , z=1
        }
    }


