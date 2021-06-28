public class Demo03 {

    public static void main(String[] args) {
        char CH = 'J';
        char ch = (char) (CH + 32);
        System.out.println("CH:" + CH + " ch:" + ch);

        char ch2 = 'a';
        System.out.println(" ch2:" + ch2);
        ch2 -= 32;
        System.out.println(" ch2:" + ch2);

        double d3 = 3.5;
        int i3 = 100;
        double sum3 = d3 + i3;
        System.out.println("sum3："+sum3+'\n'+"sum3无小数："+(int) sum3);

        double d4 = 4.5;
        int i4 = 5;
        int sum4= (int) (d4* i4);
        System.out.println("sum4:"+sum4);

    }
}
