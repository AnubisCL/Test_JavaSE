public class Test01 {

    public static void main(String[] args) {
        //2.5 定义方法练习 练习一
        /*比较两个整数是否相同
分析：定义方法实现功能，需要有两个明确，即 返回值 和 参数列表 。
明确返回值：比较整数，比较的结果只有两种可能，相同或不同，因此结果是布尔类型，比较的结果相
同为true。
明确参数列表：比较的两个整数不确定，所以默认定义两个int类型的参数。*/
        int a=11,b=12;

        boolean bool = compareNum(a, b);

        System.out.println(bool);
    }

    private static boolean compareNum(int a,int b) {
        return (a==b)?true:false;
    }
}
