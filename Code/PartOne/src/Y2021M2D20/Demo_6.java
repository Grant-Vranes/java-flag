package Y2021M2D20;
import java.util.Scanner;
public class Demo_6 {
	public static void main(String[] args) {
		//三个数的排序程序
		Scanner scan = new Scanner(System.in);
		System.out.println("输入3个数：");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		if(a > b) {
			int t = a;
			a = b;
			b = t;
		}
		if(a > c) {
			int t = a;
			a = c;
			c = t;
		}
		if(b > c) {
			int  t = b;
			b = c;
			c = t;
		}
		System.out.println(a+" "+b+" "+c);
	}
}
