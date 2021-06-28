public class Demo04 {

    public static void main(String[] args) {
        int a = 10, b = 20, c = 30;
        method1();
        System.out.println("--------------");
        method2();
        System.out.println("--------------");
        System.out.println(a + "\n" + b + "\n" + c);

    }

    private static void method2() {
        int a = 0;
        while (a <= 5) {
            for (int b = 1; b <= 5; b++) {
                System.out.print(b + " ");
            }
            System.out.println();
            a++;
        }
    }

    private static void method1() {
        int a = -5;
        int b = --a;
        if (a % 2 == 0) {
            a = ++b;
        } else {
            b = --a;
        }
        System.out.println("a:" + a + "\nb:" + b);
    }
}
