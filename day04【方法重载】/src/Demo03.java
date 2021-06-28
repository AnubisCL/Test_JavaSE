public class Demo03 {

    public static void main(String[] args) {
        String str = "red";
        showColor(str);


    }

    private static void showColor(String str) {
        switch (str) {
            case "red":
                System.out.println(str + "是红色！");
                break;
            case "yellow":
                System.out.println(str + "是黄色！");
                break;
            case "blue":
                System.out.println(str + "是蓝色！");
                break;
            case "white":
                System.out.println(str + "是白色！");
                break;
            case "black":
                System.out.println(str + "是黑色！");
                break;
            default:
                System.out.println("未找到此颜色！");
        }
    }
}
