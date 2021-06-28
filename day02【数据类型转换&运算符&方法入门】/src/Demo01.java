public class Demo01 {

    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        byte b3 = (byte) (b1 + b2);     //(b1 + b2) => int
        System.out.println("byte类型b1和b2的和为：" + b3);

        short s1 = 1000;
        short s2 = 2000;
        short s3 = (short) (s1 + s2);   //(s1 + s2) => int
        System.out.println("short类型s1和s2的和为：" + s3);

        char c1 = 'a';
        int i1 = 30;
        int ch1 = (c1-i1);      //(c1 + i1) => int
        System.out.println("char类型c1和int类型的i1的差为：" + ch1);



    }

}
