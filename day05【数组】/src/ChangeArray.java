import java.util.Arrays;

public class ChangeArray {

    public static void main(String[] args) {

        int[] arr = ThreeArrayList.newRandomList(9);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        reArrayList(arr);

        System.out.println(Arrays.toString(arr));

        arrayMaxToMin(arr);

        System.out.println(Arrays.toString(arr));


    }


    //交换max min (+)
    private static void arrayMaxToMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int maxIndex = 0;
        int minIndex = 0;



        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }

            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        //System.out.println(maxIndex+" "+minIndex);
        arr[maxIndex] = arr[maxIndex] ^ arr[minIndex];
        arr[minIndex] = arr[maxIndex] ^ arr[minIndex];
        arr[maxIndex] = arr[maxIndex] ^ arr[minIndex];


    }

    //反转
    private static void reArrayList(int[] arr) {
        int temp = 0;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}
