package Y2021M5D18_Date;

import java.util.Calendar;

/**
 * 	void set(int field, int value)
 * 	对指定的时间分量设置指定的值
 * @author Grant·Vranes
 *
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * 	表示2008-08-08 20:08:08
		 */
		//可以直接全部设置
//		calendar.set(year, month, date, hourOfDay, minute, second);
		//也可以单独设置
		calendar.set(Calendar.YEAR, 2008);
		calendar.set(Calendar.MONDAY, Calendar.AUGUST);
		calendar.set(Calendar.DATE, 8);
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 8);
		calendar.set(Calendar.SECOND, 8);
		//下面的getTime输出如果注释掉，后面的输出结果不同
		System.out.println(calendar.getTime());
		
		/*
		 * 	上面设置日期为8号，但是set方法并非在每次设置后就真的将时间
		 * 	分量改为该对对应值，而是在getTime时进行实际计算，但是下面
		 * 	的代码在设置星期几时会影响月中的天，这会导致刚才设置的8号被
		 * 	覆盖等于没做。
		 * 	对此的解决办法是，当设置出现相互影响时，可以在之前设置过后主
		 * 	动调用一次 getTime方法让 Calendar进行一次调整运算后再设
		 * 	置就没有问题了。可以取消上面的注释看看前后效果
		 */
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println(calendar.getTime());
		
		
	}
}
