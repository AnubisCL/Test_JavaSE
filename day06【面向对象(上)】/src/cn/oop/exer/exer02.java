package cn.oop.exer;

public class exer02 {

    public static void main(String[] args) {

        Wife wife = new Wife("Aa",33);
        Husband husband = new Husband("Bb",22);

        wife.setHusband(husband);
        husband.setWife(wife);

        System.out.println(wife.toString());
        System.out.println("------------");
        System.out.println(husband.toString());
    }
}
class Husband{
    private String name;
    private int age;
    private Wife wife;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public Husband(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wifename=" + wife.getName() +
                ", wifeage=" + wife.getAge() +
                '}';
    }
}

class Wife{
    private String name;
    private int age;
    private Husband husband;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public Wife(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", husbandname=" + husband.getName() +
                ", husbandage=" + husband.getAge() +
                '}';
    }
}