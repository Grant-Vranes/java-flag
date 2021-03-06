package Y2021M5D18_Date;

import java.util.Calendar;

/**
 * 	void add(int field, int amount)
 * 	对指定的时间分量累加给定值。若给定的值为负数则是减去。
 * 	该计算与set不同，调用一次后就会真实进行一次计算操作。
 * @author Grant·Vranes
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * 	3年5个月零25天以后是哪一天?
		 */
		//加3年
		calendar.add(Calendar.YEAR, 3);
		//加5个月
		calendar.add(Calendar.MONTH, 5);
		//加25天
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		System.out.println(calendar.getTime());//Tue Nov 12 15:56:00 CST 2024
		
		/*
		 * 	查看当周的周六是哪天？
		 */
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		System.out.println(calendar.getTime());//Sat Nov 16 15:57:26 CST 2024
		
	}
}
