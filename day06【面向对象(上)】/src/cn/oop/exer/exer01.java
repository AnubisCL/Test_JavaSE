package cn.oop.exer;

public class exer01 {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("柴磊");
        s1.setGender("man");
        s1.setAge(21);
        s1.setId(1);
        s1.setScore(98.5);

        s1.say();
    }

}

class Student{

    private String name;
    private String gender;
    private int age;
    private int id;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String say() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", score=" + score +
                '}';
    }
}
