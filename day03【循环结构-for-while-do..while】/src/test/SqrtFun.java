package test;

import java.util.Scanner;

public class SqrtFun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();


        if (a == 0) {
            int x = -c / b;
            System.out.println(x);
        } else {
            double temp = b * b - 4 * a * c;
            if (temp > 0) {
                double x1 = -b + Math.sqrt(temp) / 2 * a;
                double x2 = -b - Math.sqrt(temp) / 2 * a;
                System.out.println("解为：x1="+x1+" x2="+x2);
            } else if (temp==0){
                double x = -b/2*a;
                System.out.println("解为：x1=x2="+x);

            } else {
                System.out.println("无解");
            }

        }

    }
}
