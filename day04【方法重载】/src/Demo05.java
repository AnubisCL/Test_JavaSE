public class Demo05 {

    public static void main(String[] args) {
        printX(30);
    }

    private static void printX(int i) {
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                if (j==k || j+k==i-1){
                    System.out.print("O");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
