package cn.test.Stringexer;

//算法题
//1.模拟一个trim方法，去除字符串两端的空格。
public class exer1 {

    public static void main(String[] args) {
        //String str = "  a bc d e       ";
        //String str = null;
        //String str = "";
        //String str = "  a  ";
        //String str = "a";
        //String str = " ";
        String str = "  ";
        System.out.println("str.length():" + str.length());
        System.out.println("str:[" + str + "]");

        exer1 e1 = new exer1();
        System.out.println("trimStr.length():" + e1.trimExer(str).length());
        System.out.println("trimStr:[" + e1.trimExer(str) + "]");

    }

    public String trimExer(String str) {
        if (str != null && str != "") {
            int start = 0;
            int end = str.length() - 1;
            //两边无空格
            if (str.charAt(start) != ' ' && str.charAt(end) != ' ') {
                return str;
            }
            //有空格
            String newStr = null;
            while (true) {
                //开始有空格
                if (str.charAt(start) == ' ' && start < end) {
                    start++;
                }
                //结尾有空格
                if (str.charAt(end) == ' ' && start < end) {
                    end--;
                }
                //结束
                //全空格
                if (start==end && str.charAt(start) == ' '){
                    return "";
                }
                //有其他字符
                if (str.charAt(start) != ' ' && str.charAt(end) != ' '){
                    newStr = str.substring(start, end + 1);
                    return newStr;
                }
            }

        }
        return str;
    }


}


