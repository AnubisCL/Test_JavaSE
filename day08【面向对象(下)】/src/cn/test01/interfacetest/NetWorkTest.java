package cn.test01.interfacetest;

//代理模式（静态代理）
public class NetWorkTest {

    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface NetWork{
    //可省略 public abstract
    public abstract void browse();
}

//被代理类
class Server implements NetWork{

    @Override
    public void browse() {
        System.out.println("真正的连接服务器过程！");
    }
}

//代理类
class ProxyServer implements NetWork{

    //直接声明接口（多态）
    private NetWork work;

    public ProxyServer(NetWork work){
        this.work = work;
    }

    public void check(){
        System.out.println("连接服务器的检查操作！");
    }

    @Override
    public void browse() {
        check();
        //代理
        work.browse();
    }
}
