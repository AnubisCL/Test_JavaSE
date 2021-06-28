public class Demo01 {

    public static void main(String[] args) {
        // 定义int类型a为10, b为10.
        int a = 10;
        int b = 10;
        printNum(a, b);
        doubling(a, b);
        printNum(a, b);

        System.out.println("***********************");

        a = doubling(a);
        b = doubling(b);
        printNum(a, b);
    }

    // 定义printNum方法,参数为(int iVar, int iVar2),返回值无,输出iVar和iVar2的值
    public static void printNum(int iVar, int iVar2) {
        System.out.println("iVar:" + iVar + ", iVar2:" + iVar2);
    }

    // 定义doubling方法,参数为(int r, int p),返回值无,方法内r翻倍,p翻倍,并调用printNum方法,输出r和p的值
    public static void doubling(int r, int p) {
        r *= 2;
        p *= 2;
        System.out.println("翻倍:r=" + r + ",p=" + p);
    }

    // 定义doubling方法,参数为(int r),返回值int, 方法内r翻倍,返回r.
    public static int doubling(int r) {
        r *= 2;
        return r;
    }
}

