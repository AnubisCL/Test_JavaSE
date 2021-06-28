import java.util.Arrays;

public class ThreeArrayList {

    public static void main(String[] args) {

        int[] arr1 = newRandomList(10);
        int[] arr2 = newRandomList(10);
        int[] arr3 = newRandomList(10);

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    //new Arrays
    static int[] newRandomList(int size) {
        int[] arr = new int[size];
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = (int) (Math.random() * 30 + 1);
            while (true) {
                if (true==noSame(num, Arrays.copyOf(arr, i+1))){
                    arr[i] = num;
                    break;
                }else {
                    num = (int) (Math.random() * 30 + 1);
                }
            }
        }
        return arr;
    }

    //not same
    public static boolean noSame(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]){
                return false;
            }
        }
        return true;
    }
}
