package Y2021M5D18_Date;

import java.util.Calendar;
import java.util.Date;

/**
 * 	java.util.Calendar
 * 	日历类
 * 	Calendar是用来操作时间的API，使用非常的方便。
 * 	但本身是一个抽象类，提供了一个用于获取实现类的静
 * 	态方法：getInstance()，该方法可以根据当前系统
 * 	所在地区获取一个适用的实现类
 * 	大部分地区获取回来的都是：GregorianCalendar
 * 	即：阳历
 * @author Grant·Vranes
 *
 */
public class CalendarDemo1 {
	public static void main(String[] args) {
		//Calendar默认也表示当前系统时间
		Calendar calendar = Calendar.getInstance();
		/*
		 * 	Calendar的toString输出的信息很多，但是不能直观的看出具体日期
		 */
		System.out.println(calendar);
		
		/*
		 * 	Date getTime()
		 * 	Calendar提供的 getTime方法可以获取一个Date，
		 * 	该实例表示的就是当前calendar所表示的日期
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
		/*
		 * 	Calendar另一个方法：
		 * 	void setTime(Datedate)
		 * 	该方法可以让当前 Calendar表示给定的Date所表示的日期
		 */
	}
}
