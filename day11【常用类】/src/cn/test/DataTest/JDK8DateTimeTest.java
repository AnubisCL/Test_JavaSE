package cn.test.DataTest;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 *
 * @author shkstart
 * @create 2019 下午 2:44
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate() {
        //偏移量
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1);//Tue Sep 08 00:00:00 GMT+08:00 2020
    }

    /*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
     */
    @Test
    public void test1() {
        //实例化
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();  //2021-05-01
        LocalTime localTime = LocalTime.now();  //13:53:26.188
        LocalDateTime localDateTime = LocalDateTime.now();  //2021-05-01T13:53:26.188

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒。没有【偏移量】
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);


        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());  //1
        System.out.println(localDateTime.getDayOfWeek());   //SATURDAY
        System.out.println(localDateTime.getMonth());   //MAY
        System.out.println(localDateTime.getMonthValue());  //5
        System.out.println(localDateTime.getMinute());  //53

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);  //2021-05-01
        System.out.println(localDate1); //2021-05-22


        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);     //2021-05-01T13:53:26.188
        System.out.println(localDateTime2);    //2021-05-01T04:53:26.188


        //不可变性
        //plusXxx():在当前基础上增加
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //minusXxx():在当前基础上减少
        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /*
    瞬时：Instant的使用
    类似于 java.util.Date类
     */
    @Test
    public void test2() {
        //实例化
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2019-02-18T07:29:41.719Z

        //添加时间的偏移量  .atOffset(ZoneOffset.ofHours(8)) （北京在东八区-本初子午线在英国伦敦）
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2019-02-18T15:32:50.611+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1550475314878L);
        System.out.println(instant1);
    }


    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
    */
    @Test
    public void test3() {
        //方式一：预定义的标准格式。如：
        // ISO_LOCAL_DATE_TIME  ;
        // ISO_LOCAL_DATE  ;
        // ISO_LOCAL_TIME  ;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);      //2021-05-01T14:16:39.755
        System.out.println(str1);   //2021-05-01T14:16:39.755

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);     //{},ISO resolved to 2019-02-18T15:42:18.797

        //方式二：
        //本地化相关的格式。如：ofLocalizedDateTime()
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);
        //2019年2月18日 下午03时47分16秒 / 2021-5-1 15:35:09 / 21-5-1 下午3:35


        //本地化相关的格式。如：ofLocalizedDate()
        //FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);
        //2021年5月1日 星期六 / 2021年5月1日 / 2021-5-1 / 21-5-1


        //重点: 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);   //2021-05-01 03:38:10

        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);

    }

}
