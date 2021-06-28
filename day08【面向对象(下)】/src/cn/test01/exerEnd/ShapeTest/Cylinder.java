package cn.test01.exerEnd.ShapeTest;

public class Cylinder extends Circle {

    private double height;

    /**
     * 求圆柱的体积
     * @return
     */
    public double volume(){
        double area = super.area();
        return area * height;
    }

    /**
     * 求圆柱的表面积
     * @return
     */
    @Override
    public double area() {
        double area = super.area();
        double perimeter = super.perimeter();
        return area * 2 + perimeter * height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double raides, double height) {
        super(raides);
        this.height = height;
    }

    public Cylinder(double raides) {
        super(raides);
    }
}
