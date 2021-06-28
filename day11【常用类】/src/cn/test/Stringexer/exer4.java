package cn.test.Stringexer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*4.获取两个字符串中最大相同子串。比如：
    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
    提示：将短的那个串进行长度依次递减的子串与较长的串比较。*/
public class exer4 {

    // 如果存在多个长度相同的最大相同子串：使用ArrayList
	public List<String> getMaxSameSubString2(String str1, String str2) {
		if (str1 != null && str2 != null) {
			List<String> list = new ArrayList<String>();
			String maxString = (str1.length() > str2.length()) ? str1 : str2;
			String minString = (str1.length() > str2.length()) ? str2 : str1;

			int len = minString.length();
			for (int i = 0; i < len; i++) {
				for (int x = 0, y = len - i; y <= len; x++, y++) {
					String subString = minString.substring(x, y);
					if (maxString.contains(subString)) {
						list.add(subString);
					}
				}
				if (list.size() != 0) {
					break;
				}
			}
			return list;
		}
		return null;
	}


    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameSubString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
                System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;
    }

    public String getMaxSameSubString(String str1, String str2) {
        if (str1 != null && str2 != null){
            String longStr = (str1.length() >= str2.length()) ? str1 : str2;
            String shortStr = (str1.length() >= str2.length()) ? str2 : str1;

            int len = shortStr.length();

            //循环遍历短字符串
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    //boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
                    if (longStr.contains(shortStr.substring(x, y))) {
                        return shortStr.substring(x, y);
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void testGetMaxSameSubString(){

        System.out.println("dzxa".substring(0, 4));
    }

}
