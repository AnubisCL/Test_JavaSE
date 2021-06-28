import java.util.Arrays;

public class Test02 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        System.out.println("arr = "+Arrays.toString(reSort(arr)));
    }

    private static int[] reSort(int[] arr) {
        for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
            arr[i] += arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] -= arr[j];
        }
        return arr;
    }


}
