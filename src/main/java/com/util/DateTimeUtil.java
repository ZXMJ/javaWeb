package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class DateTimeUtil {

	private static Properties pro = null;

	static {
		pro = new Properties();
		// System.out.println("DateTimeUtil static 被加载...");
		InputStream inStream = DateTimeUtil.class.getClassLoader().getResourceAsStream("common.properties");
		try {
			pro.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: 时间戳转为日期字符串
	 *
	 * @date 2017年3月13日,上午10:59:49
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param timeMillis
	 * @param pattern
	 *            被转换日期的时间格式
	 * @return
	 * 
	 */
	public static String getStringByTimeMillis(long timeMillis, String pattern) {
		pattern = checkDatePattern(pattern);
		String str = getStringByDateTime(new Date(timeMillis), pattern);
		return str;
	}

	/**
	 * @Description: 日期字符串转为时间戳
	 *
	 * @date 2017年3月13日,上午9:47:45
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param dateTime
	 *            被转换日期的字符串
	 * @param pattern
	 *            被转换日期的时间格式
	 * @return
	 * @throws ParseException
	 * 
	 */
	public static long getTimeMillisByString(String dateTime, String pattern) throws ParseException {
		pattern = checkDatePattern(pattern);
		Date date = getDateTimeByString(dateTime, pattern);
		return date.getTime();

	}

	/**
	 * @Description: 字符串转日期
	 *
	 * @date 2017年3月13日,上午9:47:17
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param dateTime
	 *            被转换日期的字符串
	 * @param pattern
	 *            被转换日期的时间格式
	 * @return
	 * @throws ParseException
	 * 
	 */
	public static Date getDateTimeByString(String dateTime, String pattern) throws ParseException {
		pattern = checkDatePattern(pattern);
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateTime);
		return date;
	}

	/**
	 * @Description: 日期转为字符串
	 *
	 * @date 2017年3月13日,上午9:52:41
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param date
	 *            被转换日期的字符串
	 * @param pattern
	 *            被转换日期的时间格式
	 * @return
	 * 
	 */
	public static String getStringByDateTime(Date date, String pattern) {
		pattern = checkDatePattern(pattern);
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		String str = dateFormat.format(date);
		return str;
	}

	/**
	 * @Description: 日期时间转为字符串
	 *
	 * @date 2017年3月13日,上午10:07:11
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param date
	 *            被转换的日期时间
	 * @param dateStyle
	 *            转换后的日期样式
	 * @param timeStyle
	 *            转换后的时间样式
	 * @param locale
	 *            国际化对象
	 * @return
	 */
	public static String getStringByDateTime(Date date, int dateStyle, int timeStyle, Locale locale) {
		checkDate(date);
		dateStyle = checkDateStyle(dateStyle);
		timeStyle = checkTimeStyle(timeStyle);
		DateFormat dateFormat = DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale);
		String str = dateFormat.format(date);
		return str;
	}

	public static void checkDate(Date date) {
		if(date==null){
			throw new NullPointerException("日期为空");
		}
	}

	/**
	 * @Description: 时间转为字符串
	 *
	 * @date 2017年3月13日,上午10:07:28
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param date
	 *            被转换的日期时间
	 * @param dateStyle
	 *            转换后的日期样式
	 * @param locale
	 *            国际化对象
	 * @return
	 */
	public static String getStringByDate(Date date, int dateStyle, Locale locale) {
		dateStyle = checkDateStyle(dateStyle);
		DateFormat dateFormat = DateFormat.getDateInstance(dateStyle, locale);
		String str = dateFormat.format(date);
		return str;
	}

	/**
	 * @Description: 日期转为字符串
	 *
	 * @date 2017年3月13日,上午10:07:34
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param date
	 *            被转换的日期时间
	 * @param timeStyle
	 *            转换后的时间样式
	 * @param locale
	 *            国际化对象
	 * @return
	 */
	public static String getStringByTime(Date date, int timeStyle, Locale locale) {
		timeStyle = checkTimeStyle(timeStyle);
		DateFormat dateFormat = DateFormat.getTimeInstance(timeStyle, locale);
		String str = dateFormat.format(date);
		return str;
	}

	/**
	 * @Description: 检测日期样式
	 *
	 * @date 2017年3月13日,上午10:57:56
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param pattern(可以使各种形式)
	 * 获取当前时间的年月日时分秒
	 *            yyyy-MM-dd HH:mm:SS：小时使用24时制，秒使用1000毫秒制
	 *            yyyy年MM月dd日 HH时mm分ss秒：小时使用24时制，秒使用60秒制
	 *            yyyyMMddhhmmSS：小时使用12时制，秒使用1000毫秒制
	 *            MM/dd/yyyy hh:mm:ss：小时使用12时制，秒使用60秒制
	 * 获取当前时间的部分值
	 *            HH	使用24时制,当前时间的小时数
	 *            ww	当前时间的周数
	 *            FF	当前时间的星期数
	 * @return
	 * 
	 */
	public static String checkDatePattern(String pattern) {
		if (pattern == null || pattern.trim().equals("")) {
			pattern = pro.getProperty("datePattern");
		}
		return pattern;
	}

	/**
	 * @Description: 检测时间风格
	 *
	 * @date 2017年3月13日,上午11:12:23
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param timeStyle
	 * @return
	 */
	public static int checkTimeStyle(int timeStyle) {
		if (timeStyle < 1 || timeStyle > 4) {
			timeStyle = Integer.parseInt(pro.getProperty("timeStyle"));
		}
		return timeStyle;
	}

	/**
	 * @Description: 检测日期风格
	 *
	 * @date 2017年3月13日,上午11:12:43
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param dateStyle
	 * @return
	 */
	public static int checkDateStyle(int dateStyle) {
		if (dateStyle < 0 || dateStyle > 3) {
			dateStyle = Integer.parseInt(pro.getProperty("dateStyle"));
		}
		return dateStyle;
	}
}