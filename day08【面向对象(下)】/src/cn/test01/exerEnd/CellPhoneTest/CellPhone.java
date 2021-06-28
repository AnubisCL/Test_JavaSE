package cn.test01.exerEnd.CellPhoneTest;


public class CellPhone {

    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        Calculator calculator = cellPhone.new Calculator();
        Clock clock = cellPhone.new Clock();
        calculator.work();
        clock.work();
    }

    class Calculator {
        public void work(){
            System.out.println("运算");
        }
    }

    class Clock {
        public void work(){
            System.out.println("计时");
        }
    }
}
