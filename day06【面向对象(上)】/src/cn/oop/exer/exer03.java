package cn.oop.exer;

public class exer03 {

    public static void main(String[] args) {
        //while (loopFlag){ }
    }
}

class Account{
    private String cid;
    private int balance;
    private Customer toCustomer;

    public boolean withdraw(int subMoney){
        if (subMoney<=0){
            System.out.println("参数错误");
            return false;
        }
        if (balance < subMoney){
            System.out.println("取钱失败");
            return false;
        }
        balance -= subMoney;
        System.out.println("取钱成功,余额："+balance);
        return true;
    }

    public boolean save(int addMoney){
        if (addMoney<=0){
            System.out.println("参数错误");
            return false;
        }
        balance += addMoney;
        System.out.println("存钱成功,余额："+balance);
        return true;
    }

    public String getInfo() {
        return "Account{" +
                "cid='" + cid + '\'' +
                ", balance=" + balance +
                ", toCustomer=" + toCustomer.getName() +
                '}';
    }

    public Account(){ }

    public Account(String cid, int balance, Customer toCustomer) {
        this.cid = cid;
        this.balance = balance;
        this.toCustomer = toCustomer;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Customer getToCustomer() {
        return toCustomer;
    }

    public void setToCustomer(Customer toCustomer) {
        this.toCustomer = toCustomer;
    }
}

class Customer{
    private String name;
    private String idNum;
    private int phoneNum;
    private String homeMessage;

    public String say() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", idNum='" + idNum + '\'' +
                ", phoneNum=" + phoneNum +
                ", homeMessage='" + homeMessage + '\'' +
                '}';
    }

    public Customer() {}

    public Customer(String name, String idNum, int phoneNum, String homeMessage) {
        this.name = name;
        this.idNum = idNum;
        this.phoneNum = phoneNum;
        this.homeMessage = homeMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHomeMessage() {
        return homeMessage;
    }

    public void setHomeMessage(String homeMessage) {
        this.homeMessage = homeMessage;
    }
}