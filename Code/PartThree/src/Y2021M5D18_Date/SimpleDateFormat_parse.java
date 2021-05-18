package Y2021M5D18_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 	将一个字符串解析为一个Date
 * @author Grant·Vranes
 *
 */
public class SimpleDateFormat_parse {
	public static void main(String[] args) throws ParseException {
		String str = "2008-08-08 20:08:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = sdf.parse(str);
		System.out.println(date);//Fri Aug 08 20:08:08 CST 2008
	}
}
