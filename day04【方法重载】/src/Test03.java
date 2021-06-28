public class Test03 {

    public static void main(String[] args) {
    //调用方法printHelloWorld，传递整数
        printHelloWorld(9);
    }

    /*
    定义打印HelloWorld方法
    返回值类型，计算没有结果 void
    参数：不确定打印几次
    */
    public static void printHelloWorld(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("HelloWorld");
        }
    }

}
