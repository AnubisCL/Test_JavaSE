public class Demo02 {

    public static void main(String[] args) {
        int i1 = 100;
        long l1 = 200;
        long add = i1 + l1;     //long > int
        System.out.println("add:"+add);

        float f2 = 0.45F;
        long l2 = 1000000;
        float add2 = f2 + l2;   //float > long
        System.out.println("add2:"+add2);


        int i3 = 1000000;
        double d3 = 0.45;
        double add3 = i3 + d3;      //double > int
        System.out.println("add3:"+add3);


        float f4 = 1000000.789F;
        double d4 = 0.45;
        double add4 = f4 + d4;      //double > float
        System.out.println("add4:"+add4);

    }
}
