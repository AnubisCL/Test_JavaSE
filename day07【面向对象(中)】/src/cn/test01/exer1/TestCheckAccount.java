package cn.test01.exer1;

public class TestCheckAccount {

    public static void main(String[] args) {

        CheckAccount checkAccount1 = new CheckAccount(1122, 20000, 0.045, 5000);

        checkAccount1.withdraw(5000);
        System.out.println();
        checkAccount1.withdraw(18000);
        System.out.println();
        checkAccount1.withdraw(3000);
        System.out.println();
        System.out.println("您的账户余额：" + checkAccount1.getBalance());
        System.out.println("您的可透支余额：" + checkAccount1.getOverdraft());

    }
}
