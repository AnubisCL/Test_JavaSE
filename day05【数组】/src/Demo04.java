public class Demo04 {

    public static void main(String[] args) {

        char[] str = {'a', 'l', 'f', 'm', 'f', 'o', 'b', 'b', 's', 'n'};

        //System.out.println((int) ('a'));    //97-122
        printCount(str);

    }

    private static void printCount(char[] str) {
        int[] arr = new int[123];
        for (int i = 0; i < str.length; i++) {
            arr[(int) (str[i])]++;
        }
        //打印;
        for (int i = 97; i < 123; i++) {
            if (arr[i] != 0) {
                System.out.println((char) (i) + "--" + arr[i]);
            }
        }
    }


}
