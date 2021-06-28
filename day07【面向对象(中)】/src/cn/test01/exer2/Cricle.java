package cn.test01.exer2;

import java.text.NumberFormat;

public class Cricle {

    private double radius;

    NumberFormat nf = NumberFormat.getNumberInstance();

    public String findArea(double radius) {
        nf.setMaximumFractionDigits(2);
        return nf.format(Math.PI * radius * radius);
    }

    public Cricle() {
    }

    public Cricle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
