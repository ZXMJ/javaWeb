package com.format;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class FormatTest {

	/**
	 * @Description: TODO
	 *
	 * @date 2017年3月10日,下午3:50:21
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testResourceBundle() {
		// Locale locale = Locale.CHINA;
		Locale locale = Locale.US;
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", locale);
		String str = "{0}: {1} , {2}: {3}";
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		double salary = 123456.789d;
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String result = MessageFormat.format(str, resourceBundle.getString("date"), dateFormat.format(date),
				resourceBundle.getString("salary"), numberFormat.format(salary));
		System.out.println(result);
	}

	/**
	 * @Description: 格式化模式字符串 模式字符串: 带占位符的字符串: "Date: {0}, Salary: {1}"
	 * @date 2017年3月10日,下午3:45:05
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testMessageFormat() {
		Locale locale = Locale.CHINA;
		String str = "date: {0} , salary: {1}";
		Date date = new Date();
		double number = 123456.789d;
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		numberFormat.setMaximumFractionDigits(3);
		String result = MessageFormat.format(str, dateFormat.format(date), numberFormat.format(number));
		System.out.println(result);
	}

	/**
	 * @Description: 小数的字符串转化为数字格式、货币格式
	 *
	 * @date 2017年3月10日,上午10:09:40
	 * @author fanbaoshen
	 * @version 5.0
	 * @throws ParseException
	 *
	 */
	@Test
	public void testStringToNumberFormat() throws ParseException {
		// Locale locale = Locale.CHINA;
		// String strNum = "12,345,678.789";
		// String strCurrency = "￥12,345,678.789";
		Locale locale = Locale.FRANCE;
		String strNum = "12 345 678,789";
		String strCurrency = "12 345 678,789 €";
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		System.out.println(numberFormat.parse(strNum));
		numberFormat = NumberFormat.getCurrencyInstance(locale);
		System.out.println(numberFormat.parse(strCurrency));
	}

	/**
	 * @Description: 小数转化为数字格式、货币格式的字符串
	 *
	 * @date 2017年3月10日,上午10:09:40
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testNumberToStringFormat() {
		// Locale locale = Locale.CHINA;
		Locale locale = Locale.FRANCE;
		double num = 12345678.789d;
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		System.out.println(numberFormat.format(num));
		numberFormat = NumberFormat.getCurrencyInstance(locale);
		// 最大保留的小数位数，默认两位，多余的四舍五入
		numberFormat.setMaximumFractionDigits(3);
		System.out.println(numberFormat.format(num));
	}

	/**
	 * @Description: 字符串转化为日期格式 
	 * 方法一 ：(常用) 创建SimpleDateFormat对象
	 * 方法二 ：使用DateFormat.getDateInstance(DateFormat.MEDIUM, locale)获取对象
	 * 		    注意：DateFormat.MEDIUM参数格式要和被转化的字符串格式一样
	 * @date 2017年3月10日,上午9:46:42
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @throws ParseException
	 */

	@Test
	public void testStringToDateFormat() throws ParseException {
		Locale locale = Locale.CHINA;
		// Locale locale = Locale.US;
		String str = "2017-3-10 13:31:34";
		// MM代表月，mm代表分钟，所以前后大小写要区分
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale);
		System.out.println(dateFormat.parse(str));

		dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		System.out.println(dateFormat.parse(str));
	}

	/**
	 * @Description: 日期格式的日期、时间、日期时间转化为字符串
	 * 
	 * @date 2017年3月10日,上午9:12:10
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @throws ParseException
	 */
	@Test
	public void testDateToStringFormat() {
		Locale locale = Locale.CHINA;
		Date date = new Date();
		System.out.println(date);
		// 日期格式的日期转化为字符串
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		System.out.println(dateFormat.format(date));

		// 日期格式的时间转化为字符串
		dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getTimeInstance(DateFormat.LONG, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getTimeInstance(DateFormat.FULL, locale);
		System.out.println(dateFormat.format(date));

		// 日期格式的日期时间转化为字符串
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		System.out.println(dateFormat.format(date));
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
		System.out.println(dateFormat.format(date));

	}

	/**
	 * @Description: Local对象创建的两种方式
	 *
	 * @date 2017年3月10日,上午9:42:15
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	@Test
	public void testLocale() {
		Locale locale = Locale.CHINA;
		// Locale locale = new Locale("en", "US");
		System.out.println(locale.getLanguage());
		System.out.println(locale.getCountry());
	}

	@Test
	public void testDateFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddhhmmSS");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddhhmmss");
		System.out.println("sdf : " + sdf .format(new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000)));
		System.out.println("sdf1: " + sdf1.format(new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000)));
		System.out.println("sdf2: " + sdf2.format(new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000)));
		System.out.println("sdf3: " + sdf3.format(new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000)));
	}
}
