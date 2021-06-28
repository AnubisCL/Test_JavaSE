public class Demo02 {

    public static void main(String[] args) {
        double discount = 1;
        int totalPrice = 550;

        if (totalPrice >=500){
            discount = 0.5;
        } else if (totalPrice >=400 && totalPrice<500){
            discount = 0.6;
        } else if (totalPrice >=300 && totalPrice<400){
            discount = 0.7;
        }else if (totalPrice >=200 && totalPrice<300){
            discount = 0.8;
        } else{
            discount = 0.9;
        }

        System.out.println("totalPrice:"+totalPrice);
        System.out.println("totalPrice的discount:"+(totalPrice*discount));
    }
}
