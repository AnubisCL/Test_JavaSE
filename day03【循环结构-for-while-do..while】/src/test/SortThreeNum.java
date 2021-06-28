package test;

public class SortThreeNum {

    public static void main(String[] args) {
        int a = 10, b = 25, c = -7;

        Sort(a, b, c);

    }

    private static void Sort(int a, int b, int c) {
        if (a > b && a > c) {
            if (b > c) {
                System.out.print(c + " " + b + " " + a);
            } else {
                System.out.println(b + " " + c + " " + a);
            }

        }
        if (a > b && a < c) {
            System.out.println(b + " " + a + " " + c);
        }
        if (a < b && a > c) {
            System.out.println(c + " " + a + " " + b);
        }
        if (a < b && a < c) {
            if (b > c) {
                System.out.println(a + " " + c + " " + b);
            } else
                System.out.println(a + " " + b + " " + c);
        }


    }
}
