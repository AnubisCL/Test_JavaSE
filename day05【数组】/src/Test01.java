public class Test01 {

    public static void main(String[] args) {
        int[] arr = {5, 15, 2000, 99999, 100, 4000};
        System.out.println(getMax(arr));
    }

    private static int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
