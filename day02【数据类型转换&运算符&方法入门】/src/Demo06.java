public class Demo06 {
    public static void main(String[] args) {
        printNum();
    }

    public static void printNum() {
        int a = 9, b = 9;
        int num = ++a;
        boolean bo = (num >= 10) ? true : false;
        System.out.println("bo:" + bo);
        int num2 = b++;
        Boolean bo2 = (num2 >= 10) ? true : false;
        System.out.println("bo2:" + bo2);
    }

}
