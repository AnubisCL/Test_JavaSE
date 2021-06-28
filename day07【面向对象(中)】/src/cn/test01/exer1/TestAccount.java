package cn.test01.exer1;

public class TestAccount {

    public static void main(String[] args) {
        Account account1 = new Account(1122, 20000, 0.045);

        account1.withdraw(30000);
        account1.withdraw(2500);
        System.out.println();
        account1.deposit(3000);


        System.out.println("月利率：" + account1.getMonthlyInterest());


    }
}
