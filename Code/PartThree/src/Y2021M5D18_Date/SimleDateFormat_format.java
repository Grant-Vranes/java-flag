package Y2021M5D18_Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 	java.text.SimpleDateFormat
 * 	该类可以将Date与 String之间互转。依靠的是
 * 	一个日期格式字符串。
 * @author Grant·Vranes
 *
 */
public class SimleDateFormat_format {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);//Tue May 18 09:30:53 CST 2021
		
		/*
		 * 	2021-05-18 10:26:33   <-我想要的格式
		 * 	yyyy-MM-dd HH:mm:ss		
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * 	String format(Date date)
		 *	将给定的Date按照sdf指定的日期格式转换为一个字符串
		 */
		String line = sdf.format(now);
		System.out.println(line);//2021-05-18 09:30:53
	}
}
