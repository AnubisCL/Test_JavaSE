public class Demo05 {

    public static void main(String[] args) {
        int[] score = {95, 92, 75, 56, 98, 71, 80, 58, 91, 91};

        getAvg(score);


    }

    private static void getAvg(int[] score) {
        int avg = 0;
        for (int i = 0; i < score.length; i++) {
            avg += score[i];
        }
        avg = avg / score.length;
        int count = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] > avg)
                count++;
        }


        System.out.printf("高于平均分：%d 的有 %d 个；", avg, count);

    }
}
