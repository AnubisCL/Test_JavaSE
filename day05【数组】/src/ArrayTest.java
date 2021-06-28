import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

    public static void main(String[] args) {

        int[] score = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();
        }
        //show
        System.out.println("排序前:");
        System.out.println(Arrays.toString(score));
        //Sort 升序
        Arrays.sort(score);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(score));

        //Search
        int keyIndex = Arrays.binarySearch(score, 60);
        if (keyIndex < 0) {
            System.out.println("无60");
        } else {
            System.out.println("60索引：" + keyIndex);
        }

        //Copy
        int[] copyOfMin = Arrays.copyOf(score, 3);
        System.out.println(Arrays.toString(copyOfMin));


    }
}
