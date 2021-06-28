import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo06 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,2,1};
        int[] arr2 = {1,2,3,4,5,2,1};

        sym(arr);
        System.out.println("---------");
        sym(arr2);
    }

    private static void sym(int[] arr) {
        int l = 0;
        int r = arr.length -1;

        boolean bool = false;

        while (l<=r){

            if (arr[l] == arr[r]){
                bool = true;
                l++;
                r--;
            } else{
                bool = false;
                System.out.println(Arrays.toString(arr)+"是否对称："+bool);
                return;
            }
        }
        System.out.println(Arrays.toString(arr)+"是否对称："+bool);
    }
}
