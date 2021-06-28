package cn.test01.exer2;

public class CTest {

    public static void main(String[] args) {

        Cricle cricle = new Cricle();

        Cylinder cylinder = new Cylinder();

        /*
           3.141592653589793 ==> 3.14
           12.566370614359172 ==> 12.56
           3.141592653589793 ==> 3.14
        */

        System.out.println(cricle.findArea(1));

        System.out.println(cylinder.findArea(1,1));

        System.out.println(cylinder.findVolume(1,1));


    }
}
