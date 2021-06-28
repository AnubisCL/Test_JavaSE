package test;

public class MultipleOf13 {

    public static void main(String[] args) {
        label:for (int i = 1; i <= 100; i++) {
            if (i%13==0) continue label;
            System.out.print(i+" ");
        }
    }
}
