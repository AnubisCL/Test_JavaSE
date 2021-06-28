public class Demo05 {

    public static void main(String[] args) {
        int a = 20, b = 20;

        /*a++是使用a后再对a进行加1，++a是先把a加1在使用a*/
        boolean bo1 = ++a % 3 == 0 && a++ % 7 == 0;
        //System.out.println(++a % 3);
        //System.out.println(a);
        //System.out.println(a++ % 7);
        //System.out.println(a);


        System.out.println("bo1:" + bo1 + '\n' + "a:" + a);

        boolean bo2 = b++ % 3 == 0 && ++b % 7 == 0;
        System.out.println("bo2:" + bo2 + '\n' + "b:" + b);

        System.out.println((false && false));
        System.out.println((boolean) (++a % 3 == 0)+" "+(boolean) (a++ % 7 == 0));
        System.out.println((boolean) (b++ % 3 == 0)+" "+(boolean) (++b % 7 == 0));

    }
}
