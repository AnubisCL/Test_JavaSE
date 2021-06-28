public class Demo02 {

    public static void main(String[] args) {
        boolean b = doCheck(2);
        System.out.println(b);

        boolean b1 = doCheck(3);
        System.out.println(b1);
    }

    // 定义doCheck方法,参数为(int iVar),返回值boolean类型
    public static boolean doCheck(int num) {
        //        3.doCheck方法内,定义变量boolean flag.
        boolean flag;

        //        4.doCheck方法内,判断num是否为偶数.
        if (num % 2 == 0) {
            // 如果是偶数,使用for循环,初始化值i为0,i<=20进入循环,步进表达式i++
            for (int i = 0; i <= 20; i++) {
                num -= i;
            }
            flag = true;
        } else {
            // 否则是奇数,使用for循环,初始化值i为0,i<=20进入循环,步进表达式i++
            for (int i = 0; i <= 20; i++) {
                num += i;
            }
            flag = false;
        }
        // 输出num的值
        System.out.println("num:" + num);
        return flag;
    }
}
