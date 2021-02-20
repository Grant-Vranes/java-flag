package Y2021M2D20;

import java.util.Scanner;

public class Demo_4 {
	/**
	 * 闰年的判断
	 * 判断公式：
	 * 1）能被4整除，并且，不能被100整除
	 * 或者
	 * 2）能被400整除
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入年份");
		int year = scan.nextInt();
		boolean flag = (year%4==0 && year%100 != 0) || year%400==0;
		String str = flag ? year+"是闰年" : year+"不是闰年";
		System.out.println(str);
	}
}
