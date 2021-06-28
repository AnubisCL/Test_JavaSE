package cn.test.Stringexer;

//算法题
//2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
public class exer2 {

    public static void main(String[] args) {

        exer2 e2 = new exer2();

        //System.out.println("abc".substring(0, 3));
        String str = "abcdefg";
        System.out.println("str:[" + str + "]");
        System.out.println("reversString:[" + e2.reversString(str, 2, 4) + "]");


    }

    public String reversString(String str, int startIndex, int endIndex) {
        if (startIndex < 0) {
            throw new StringIndexOutOfBoundsException(startIndex);
        }
        if (endIndex > str.length()) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }
        int subLen = endIndex - startIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        String startStr = str.substring(0, startIndex);
        String endStr = str.substring(endIndex, str.length());
        System.out.println("startStr:[" + startStr + "]");
        System.out.println("endStr:[" + endStr + "]");

        char[] reversPartChar = str.substring(startIndex, endIndex).toCharArray();

        int start = 0;
        int end = reversPartChar.length - 1;
        char temp = 0;
        while (true) {
            temp = reversPartChar[start];
            reversPartChar[start] = reversPartChar[end];
            reversPartChar[end] = temp;
            start++;
            end--;
            if (start >= end) break;
        }
        return startStr + new String(reversPartChar) + endStr;
    }
}
