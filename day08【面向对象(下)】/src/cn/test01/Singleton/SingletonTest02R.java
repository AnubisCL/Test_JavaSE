package cn.test01.Singleton;

public class SingletonTest02R {
    public static void main(String[] args) {

    }
}
//单例模式
//懒汉式（线程不安全）

class Bank2{

    //1.私有化类的构造器
    private Bank2(){}

    //2.内部创建类的对象
    //4.要求此对象也必须声明为静态的
    private static Bank2 instance = null;

    //3.声明public、static的返回当前类对象的方法
    //此方法线程不安全
    //方法一：(效率不高)

    //同步方法 的 同步监视器 是 Bank2.class
    /*public static synchronized Bank getInstance(){
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }*/

    //同步方法 的 同步监视器 是 Bank2.class
    /*public static Bank2 getInstance(){
        synchronized (Bank2.class) {
            if (instance == null){
                instance = new Bank2();
            }
            return instance;
        }
    }*/

    //方法二：(效率稍高)
    public static Bank2 getInstance(){
        if (instance == null) {
            synchronized (Bank2.class) {
                if (instance == null){
                    instance = new Bank2();
                }
            }
        }
        return instance;
    }



}
