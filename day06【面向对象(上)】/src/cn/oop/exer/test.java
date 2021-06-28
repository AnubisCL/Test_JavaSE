package cn.oop.exer;

class test{
    public static void main(String[] args){
        show(0);
        show(1);
    }
    public static void show(int i){
        switch(i){
            default:
                i+=2;
            case 1:
                i+=1;
            case 4:
                i+=8;
            case 2:
                i+=4;
        }
        System.out.println("i="+i);
    }
}

