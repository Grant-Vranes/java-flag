package Y2021M2D20;
import java.util.Scanner;
public class Demo_7 {
	public static void main(String[] args) {
		//while循环经典案例：猜数字游戏
		Scanner scan = new Scanner(System.in);
		int number = (int)(Math.random()*100);
		int guess = scan.nextInt();
		while(guess != number) {
			if(guess > number) {
				System.out.println("过大");
			} else {
				System.out.println("过小");
			}
			guess = scan.nextInt();
		}
		System.out.println("恭喜你猜对了，number="+number);
	}
}
