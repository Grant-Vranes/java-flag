package Y2021M3D29_Thread;

import java.util.Scanner;


/**
 * 	倒计时程序
 * 	程序启动后，要求输入一个数字，比如:100
 * 	然后每秒输出一次，每次输出数字递减
 * 	输出到0时提示结束，程序退出。
 * @author Grant·Vranes
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数字:");
		String line = scanner.nextLine();
		Integer num = Integer.parseInt(line);
		for(;num>0;num--) {
			System.out.println(num);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("倒计时结束！");
		
	}
}
