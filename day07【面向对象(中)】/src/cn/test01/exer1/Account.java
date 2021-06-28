package cn.test01.exer1;

public class Account {

    private int id; //账号
    private double balance; //余额
    private double annualInterestRate;  //年利率

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    //返回月利率的方法
    public double getMonthlyInterest() {
        return annualInterestRate / 12;
    }

    //取款方法
    public void withdraw(double amount) {
        if (this.balance<amount){
            System.out.println("账户余额不足！");
            System.out.println("您的账户余额: " + this.balance);
            return;
        }

        this.balance -= amount;
        System.out.println("您的账户余额: " + this.balance);
    }

    //存款方法
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("您的账户余额: " + this.balance);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
