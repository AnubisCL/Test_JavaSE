package cn.test01.Singleton;

public class SingletonTest2 {

    public static void main(String[] args) {

    }
}
//单例模式
//懒汉式（线程不安全）
class Order{

    //1.私有化类的构造器
    private Order(){

    }

    //2.内部创建类的对象
    //4.要求此对象也必须声明为静态的
    private static Order instance = null;

    //3.声明public、static的返回当前类对象的方法
    public static Order getInstance(){
        if (instance == null){
            instance = new Order();
        }
        return instance;
    }



}
