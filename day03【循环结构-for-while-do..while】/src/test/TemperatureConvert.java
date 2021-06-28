package test;

public class TemperatureConvert {

    public static void main(String[] args) {
        int Fahernheit = 80;
        double Degree = (Fahernheit-32)/1.8;
        //round(float a) 返回最接近参数的 int。
        System.out.println("80 => "+Math.round(Degree));
    }
}
