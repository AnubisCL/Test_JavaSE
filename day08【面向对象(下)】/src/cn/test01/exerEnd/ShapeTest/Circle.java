package cn.test01.exerEnd.ShapeTest;

public class Circle implements Shape {

    private double radius;

    public Circle(Shape shape) {

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double raides) {
        this.radius = raides;
    }

    /**
     * 求周长
     */
    public double perimeter() {
        double cricleLength = Shape.PI * radius * 2;
        //System.out.println("周长是：" + cricleLength);
        return cricleLength;
    }

    /**
     * 求圆的面积
     * @return
     */
    @Override
    public double area() {
        double area = radius * radius * Shape.PI;
        //System.out.println("面积是：" + area);
        return area;
    }
}
