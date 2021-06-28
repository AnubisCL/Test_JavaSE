public class Demo10 {

    public static void main(String[] args) {
        int a = 100, b = 200;
        add(a, b);
        sub(a, b);
        mul(a, b);
        div(a, b);
        remain(a, b);

    }

    private static void remain(int a, int b) {
        System.out.printf("%d,%d的余数为：%d\n", a, b, a % b);
    }

    private static void div(int a, int b) {
        System.out.printf("%d,%d的商为：%d\n", a, b, a / b);
    }

    private static void mul(int a, int b) {
        System.out.printf("%d,%d的积为：%d\n", a, b, a * b);
    }

    private static void sub(int a, int b) {
        System.out.printf("%d,%d的差为：%d\n", a, b, a - b);
    }

    private static void add(int a, int b) {
        System.out.printf("%d,%d的和为：%d\n", a, b, a + b);
    }
}
