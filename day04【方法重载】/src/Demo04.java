public class Demo04 {

    public static void main(String[] args) {
        int a = 10, b = 30, c = 20;

        int max = getValue(a, b, c, "max");
        System.out.println("max:"+max);
        int min = getValue(a, b, c, "min");
        System.out.println("min:"+min);
        int max1 = getValue(a, b, c, "MAX");
        System.out.println("max1:"+max1);


    }

    private static int getValue(int a, int b, int c, String str) {

        switch (str) {
            case "max":
                return getMax(a, b, c);

            case "min":
                return getMin(a, b, c);

            default:
                System.out.println("erro!");
                return -1;
        }
    }

    private static int getMin(int a, int b, int c) {
        return (a > b ? a : b) > c ? (a > b ? a : b) : c;
    }

    private static int getMax(int a, int b, int c) {
        return (a < b ? a : b) < c ? (a < b ? a : b) : c;
    }
}
