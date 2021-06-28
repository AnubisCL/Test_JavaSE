package cn.test01.exer1;

public class HourlyedEmployee extends Employee {

    private int wage;
    private int hour;

    public HourlyedEmployee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyedEmployee{" + super.toString() + '}';
    }
}