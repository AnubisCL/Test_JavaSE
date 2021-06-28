import java.util.Random;

public class Demo09 {

    public static void main(String[] args) {
        printString();
        
    }

    private static void printString() {
        String str;
        int num = 9;
        str = (num/2==0)?"偶数":"奇数";
        System.out.printf("%d是"+str,num);

    }
}
