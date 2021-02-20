package Y2021M2D20;

import java.util.Scanner;

public class Demo_8 {
	/**
	 * for循环经典案例：随机加法运算器
  		1）程序一次出10道加法题目，由用户输入题目的答案
    	2）用户每答完一道题，程序判断对错，并提示“答对”或“答错”
    	3）10道题目答完之后，系统计算得分并输出
    	4）希望用户提前结束，可以输入-1提前退出
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0;
		for (int i = 1; i <= 10; i++) {
			//1、出题		2、答题	3、判题
			int a = (int)(Math.random()*100);
			int b = (int)(Math.random()*100);
			int result = a + b;
			System.out.print("("+i+")"+a+"+"+b+"=");
			
			int answer = scan.nextInt();
			
			if(answer == -1) {
				break;
			}
			if(answer == result) {
				score += 10;
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
		System.out.println("得分为"+score);
	}
}
