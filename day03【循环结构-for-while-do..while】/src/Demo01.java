public class Demo01 {

    public static void main(String[] args) {
        int i = 0, i2 = 10;
        while (i < 5) {
            if (i >= 2 && i2 < 15)
                System.out.println("i:" + i + " i2:" + i2);
            i++;
            i2++;
        }
        System.out.println("---------------");
        while (i2<20){
            if (i>8 || i2<=18)
                System.out.println("i:" + i + " i2:" + i2);
            i++;
            i2++;
        }
    }
}
