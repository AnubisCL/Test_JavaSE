package cn.test01.exer1;

import java.util.Calendar;

public class PayrollSystem {

    public static void main(String[] args) {
        //方式一：
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当月月份：");
        int month = scanner.nextInt();*/
        //方式二：
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);   //0 - 11 => 1 - 12

        // 创建数组每一个位置都声明为一个 Employee 类型的数组，不是 new抽象类的对象
        Employee[] emps = new Employee[2];

        emps[0] = new SalariedEmployee("马森", 1002, new MyDate(1992, 3, 28),10000);
        emps[1] = new HourlyedEmployee("基森", 2001, new MyDate(1991, 5, 6),60,240);

        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("月工资为：" + salary);

            if (month + 1 == emps[i].getBirthday().getMonth()){
                System.out.println("生日快乐！");
            }
        }



    }
}
