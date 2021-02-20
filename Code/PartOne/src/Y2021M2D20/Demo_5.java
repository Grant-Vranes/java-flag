package Y2021M2D20;
import java.util.Scanner;
//柜台收银程序
public class Demo_5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入单价:");
		double unitPrice = scan.nextDouble();
		System.out.println("请输入数量");
		double amount = scan.nextDouble();
		System.out.println("请输入金额");
		double money = scan.nextDouble();
		
		double totalPrice = unitPrice*amount;
		if (totalPrice >= 500) {
			totalPrice *= 0.8;//满500打8折
		}
		if (money >= totalPrice) {
			double change = money-totalPrice;
			System.out.println("总价为："+totalPrice+",找零："+change);
		} else {
			System.out.println("Error,钱不够");
		}
	}
}
