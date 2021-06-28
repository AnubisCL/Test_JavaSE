package cn.test01.exerEnd.CellPhoneTest;

public class CellPhone2 {

    public static void main(String[] args) {
        CellPhone2 cellPhone2 = new CellPhone2();
        CellPhone cellPhone = cellPhone2.new CellPhone();
        Bell bell = cellPhone2.new Bell();

        cellPhone.alarmclocks(bell);

    }


    class CellPhone{

        public void alarmclocks(Bell bell){
            bell.sound();
        }
    }

    interface sound{
        public abstract void sound();
    }

    class Bell implements sound{

        @Override
        public void sound() {
            System.out.println("Ling~ Ling~ Ling~");
        }
    }
}
