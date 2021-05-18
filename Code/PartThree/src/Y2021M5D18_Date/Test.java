package Y2021M5D18_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 	编写一个程序，要求用户输入自己的生日，格式
 * 	为：yyyy-MM-dd
 * 	然后经过程序运算，输出到今天为止一共活了多少天。
 * 	再输出其出生10000天的纪念日是哪天，输出格式同样
 * 	为：yyyy-MM-dd
 * @author Grant·Vranes
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入自己的生日(格式为yyyy-MM-dd):");
		String bir = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birDate = sdf.parse(bir);//获取出生日期的Date
		
		Date now = new Date();//当前时间
		
		System.out.println("到今天为止一共活了" + (birDate.getTime()-now.getTime())/1000/60/60/24 + "天");
		
		Long niceTime = birDate.getTime() + 10000L*1000*60*60*24;//注意：数字运算都是默认int型，但当运算数据超过int的表示范围可以加个L转成long
		Date niceDate = new Date(niceTime);
		System.out.println("出生10000天的纪念日是:" + sdf.format(niceDate));
		
		
	}
}
