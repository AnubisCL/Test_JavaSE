package cn.test01.exer2;

import java.text.NumberFormat;

public class Cylinder extends Cricle {

    private double length;

    NumberFormat nf = NumberFormat.getNumberInstance();


    public String findVolume(double radius, double length) {
        nf.setMaximumFractionDigits(2);
        return nf.format(Double.parseDouble(super.findArea(radius)) * length);
    }

    public String findArea(double radius, double length) {
        double upper_lower = Double.parseDouble(super.findArea(radius)) * 2;
        double side = radius * 2 * Math.PI;
        nf.setMaximumFractionDigits(2);
        return nf.format(upper_lower + side);
    }

    public Cylinder() {
    }

    public Cylinder(double radius, double length) {
        super(radius);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
