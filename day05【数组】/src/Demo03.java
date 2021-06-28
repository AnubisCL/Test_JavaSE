import java.util.Arrays;
import java.util.Random;

public class Demo03 {

    public static void main(String[] args) {
        String[] puke = Demo02.printCard();

        String[] getPuke = getPuke(puke, 3);
        System.out.println(Arrays.toString(getPuke));

    }

    private static String[] getPuke(String[] puke, int i) {
        String[] getPuke = new String[i];

        Random r = new Random(1);
        for (int j = 0; j < i; j++) {
            getPuke[j] = puke[(int) (r.nextInt(54))];  //生成一个 [0, 54) 数，但是数字会重复
        }


        return getPuke;
    }
}
