package cn.test01.exer1;

public class CheckAccount extends Account {

    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (super.getBalance() >= amount) {
            super.withdraw(amount);
            System.out.println("您的可透支余额：" + this.getOverdraft());
        } else {
            if ((this.getOverdraft() + super.getBalance()) >= amount) {
                double resoveramount = this.getOverdraft() - (amount - super.getBalance());
                super.setBalance(0);
                this.setOverdraft(resoveramount);

                System.out.println("您的账户余额：" + super.getBalance());
                System.out.println("您的可透支余额：" + this.getOverdraft());

            } else {
                System.out.println("超过可透支额的限额!");
            }
        }
    }
}
