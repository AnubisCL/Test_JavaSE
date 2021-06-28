import java.util.Arrays;

public class Demo02 {
    public static void main(String[] args) {

        String[] puke = printCard();
        System.out.println(Arrays.toString(puke));
    }

    public static String[] printCard() {

        String[] puke = new String[54];
        int count = 0;
        // 花色数组
        String[] hs = {"♠", "♥", "♣", "♦"};
        // 点数数组
        String[] ds = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        //System.out.println("[大王]" + " " + "[小王]");
        puke[puke.length - 2] = "[大王]";
        puke[puke.length - 1] = "[小王]";

        for (int hs_index = 0; hs_index < hs.length; hs_index++) {
            for (int ds_index = 0; ds_index < ds.length; ds_index++) {

                puke[count] = "[" + hs[hs_index] + ds[ds_index] + "]";
                count++;
                // 拼接字符串
                //System.out.print(  "["+hs[hs_index] + ds[ds_index]+"] ");
            }
            // 输出换行
            //System.out.println();
        }
        return puke;
    }
}
