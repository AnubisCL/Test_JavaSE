package cn.test01.exerEnd.CarTest;

class Test{
    public static void main(String[] args) {
        Car car1 = new Car(10);
        Car car2 = new Car(45);
        Car car3 = new Car(-10);

        Car.Air air1 = car1.new Air();
        System.out.println("car1(air1){"+car1.getTemperature()+" => "+air1.flow()+"}");

        Car.Air air2 = car2.new Air();
        System.out.println("car2(air2){"+car2.getTemperature()+" => "+air2.flow()+"}");


        Car.Air air3 = car3.new Air();
        System.out.println("car3(air3){"+car3.getTemperature()+" => "+air3.flow()+"}");



    }
}

public class Car {

    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air{
        public Air() {
        }

        public String flow(){
            while (true){
                if(temperature>=40)
                    return  "吹冷气";
                if (temperature<0)
                    return "吹暖气";
                return "关闭状态";
            }
        }
    }
}
