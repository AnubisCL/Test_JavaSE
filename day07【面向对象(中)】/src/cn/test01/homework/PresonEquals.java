package cn.test01.homework;

import javax.xml.crypto.Data;
import java.util.Objects;

public class PresonEquals {

    public static void main(String[] args) {
        Person1 person1 = new Person1("柴磊", 22, "150102199903210132", "NMG");
        Person1 person2 = new Person1("柴磊", 21, "150102199903210132", "HHHT");

        System.out.println(person1.equals(person2));
    }
}

class Person1 {
    private String name;
    private int age;
    private String idNum;
    private String address;
    private Data birthday;

    public Person1(String name, int age, String idNum, String address) {
        this.name = name;
        this.age = age;
        this.idNum = idNum;
        this.address = address;
        int data = Integer.parseInt(idNum.substring(6, 14)); //[6,14)
        //System.out.println(data);
    }

    public Person1() {
    }

    @Override
    public String toString() {
        return "person{" +
                "idNum='" + idNum + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof Person1) {
            Person1 person = (Person1) o;
            return Objects.equals(name, person.name) && Objects.equals(idNum, person.idNum);
        } else return false;
    }


}