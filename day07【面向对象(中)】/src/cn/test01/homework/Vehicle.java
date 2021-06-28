package cn.test01.homework;

public class Vehicle {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(4,2);
        Car c1 = new Car(4,3,5);
        Truck t1 = new Truck(6,15,2,10);

    }

    private int wheels;
    private double weight;

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheels=" + wheels +
                ", weight=" + weight +
                '}';
    }
}

class Car extends Vehicle{
    private int loader;

    public Car(int wheels, double weight, int loader) {
        super(wheels, weight);
        this.loader = loader;
    }

    @Override
    public String toString() {
        return "Car{" +
                "loader=" + loader +
                '}';
    }
}

class Truck extends Car{
    private double payload;

    public Truck(int wheels, double weight, int loader, double payload) {
        super(wheels, weight, loader);
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payload=" + payload +
                '}';
    }
}