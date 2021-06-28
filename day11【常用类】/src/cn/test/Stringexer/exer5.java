package cn.test.Stringexer;

import java.util.Arrays;

/*5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
    提示：
    1）字符串变成字符数组。
    2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
    3）将排序后的数组变成字符串。*/
public class exer5 {

    public static void main(String[] args) {
        String str = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(new exer5().sortString(str));
    }

    public String sortString(String str){
        if (str!=null && str!= ""){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        return str;
    }
}
