package Y2021M2D20;
import java.util.Scanner;
//��̨��������
public class Demo_5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���뵥��:");
		double unitPrice = scan.nextDouble();
		System.out.println("����������");
		double amount = scan.nextDouble();
		System.out.println("��������");
		double money = scan.nextDouble();
		
		double totalPrice = unitPrice*amount;
		if (totalPrice >= 500) {
			totalPrice *= 0.8;//��500��8��
		}
		if (money >= totalPrice) {
			double change = money-totalPrice;
			System.out.println("�ܼ�Ϊ��"+totalPrice+",���㣺"+change);
		} else {
			System.out.println("Error,Ǯ����");
		}
	}
}
