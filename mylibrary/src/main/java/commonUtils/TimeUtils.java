package commonUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Flyhooo on 2016/12/20 08:53
 */

public class TimeUtils {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_FORMAT_TIME = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat STRING_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    private TimeUtils() {
        throw new AssertionError();
    }

    /**
     * long time to string
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     *
     * @return long
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @return String
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }


    /**
     * 判断给定时间在否在给定两个时间之间
     */
    public static Boolean timeCompare(String star, String end) {
        SimpleDateFormat localTime = new SimpleDateFormat("HH:mm:ss");
        try {
            Date sdate = localTime.parse(star);
            Date edate = localTime.parse(end);
            Date d=localTime.parse(getCurrentTimeInString(DATE_FORMAT_TIME));
            if (d.getTime() >= sdate.getTime() && d.getTime() < edate.getTime()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }


    /**
     * date类型转换为String类型
     *
     * @return String
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }

    /**
     * long转换为Date类型
     * <p>
     * formatType要转换的时间格式yyyy-MM-dd HH:mm:ss   yyyy年MM月dd日 HH时mm分ss秒
     */
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
//        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
//        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return dateOld;
    }

    /**
     * data Date类型的时间
     * <p>
     * formatType格式为yyyy-MM-dd HH:mm:ss  yyyy年MM月dd日 HH时mm分ss秒
     */
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    /**
     * string类型转换为date类型
     * strTime的时间格式必须要与formatType的时间格式相同
     * <p>
     * trTime要转换的string类型的时间，
     * formatType要转换的格式yyyy-MM-dd HH:mm:ss  yyyy年MM月dd日
     */
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }
}
