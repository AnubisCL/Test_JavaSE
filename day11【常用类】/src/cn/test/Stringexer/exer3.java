package cn.test.Stringexer;

import org.junit.Test;

/*3.获取一个字符串在另一个字符串中出现的次数。比如：
    获取“ab”在 “cdabkkcadkabkebfkabkskab”中出现的次数.4次*/
//BF算法 || KMP算法
public class exer3 {
    public static void main(String[] args) {

        String fStr = "aaaaaa";
        String zStr = "a";
        //String zStr = "aa";

        System.out.println(new exer3().countStr(fStr, zStr));
    }

    public int countStr(String fStr, String zStr) {
        //记录出现的次数
        int count = 0;
        char[] fchars = fStr.toCharArray();
        char[] zchars = zStr.toCharArray();
        int z = 0;
        int f = 0;
        //未比较到串尾
        while (f < fchars.length && z < zchars.length && count < fchars.length) {
            //匹配成功
            if (zchars[z] == fchars[f]) {
                //匹配到子串最后一个相等
                if (z == zchars.length - 1) {
                    z = 0;
                    count++;
                    continue;
                }
                f++;
                z++;
            } else {
                //从当前匹配的下一个字符重新匹配
                f = f - z + 1;
                z = 0;
            }
        }
        return count;
    }

    @Test
    public void testGetCount(){
        String fStr = "cdabkkcadkabkebfkabkskab";
        String zStr = "ab";

        System.out.println(new exer3().getCount(fStr, zStr));

    }

    public int getCount(String mainStr, String subStr) {
        if (mainStr.length() >= subStr.length()) {
            int count = 0;
            int index = 0;
            // while((index = mainStr.indexOf(subStr)) != -1){
            // count++;
            // mainStr = mainStr.substring(index + subStr.length());
            // }
            // 改进：
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                index += subStr.length();
                count++;
            }

            return count;
        } else {
            return 0;
        }

    }


}
