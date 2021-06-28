package test;

import java.util.Scanner;

public class NumTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.println((a % b == 0 || (a + b) > 1000) ? a : b);
    }


}
