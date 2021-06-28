public class Demo06 {

    public static void main(String[] args) {
        double num1 = 10.1;
        double num2 = 10.9;


        System.out.println(num1+" => "+roundFun(num1));
        System.out.println(num2+" => "+roundFun(num2));


    }

    private static int roundFun(double num) {
        if (num >= 10.5)
            return (int) num + 1;
        else
            return (int) num;

    }
}
