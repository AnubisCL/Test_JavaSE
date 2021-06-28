package cn.test.OtherTest;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigInteger_BigDecimalTest {

    /*
    * integer => 最大2^31-1
    * long => 最大2^63-1
    * */

    @Test
    public void test2() {
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        //System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));

    }
}
