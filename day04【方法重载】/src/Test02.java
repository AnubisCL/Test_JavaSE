public class Test02 {

    public static void main(String[] args) {
        int sum = addSumNum(1,100);
        System.out.println(sum);
        System.out.println(getSum(1,100));
    }

    private static int addSumNum(int min,int max) {
        return (max-min+1)*(min+max)/2;
    }

    public static int getSum(int min,int max){
        //定义变量保存求和
        int sum = 0;
        //从1开始循环，到100结束
        for (int i = min; i <= max; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
