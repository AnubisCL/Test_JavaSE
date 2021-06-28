package cn.test01.exerEnd;

public class LenovoTest {

    public static void main(String[] args) {
        LenovoTest lenovoTest = new LenovoTest();
        Lenovo lenovo = lenovoTest.new Lenovo();
        Lenovo.KaiFa kaiFa = lenovo.new KaiFa();
        Lenovo.XiaoShou xiaoShou = lenovo.new XiaoShou();

        kaiFa.works();
        xiaoShou.works();

    }

    interface Works {
        public abstract void works();
    }

    class Lenovo {

        class KaiFa implements Works {

            @Override
            public void works() {
                System.out.println("开发部工作");
            }
        }

        class XiaoShou implements Works {

            @Override
            public void works() {
                System.out.println("销售部工作");
            }
        }
    }


}
