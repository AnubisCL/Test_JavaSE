public class Demo07 {

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,3,2,1};
        int[] arr2 = {1,2,3,4,3,2,1};
        int[] arr3 = {1,2,4,3,3,2,1};

        System.out.println(equals(arr1,arr2));
        System.out.println(equals(arr1,arr3));

    }

    private static boolean equals(int[] arr1, int[] arr2) {
        boolean bool = false;
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
