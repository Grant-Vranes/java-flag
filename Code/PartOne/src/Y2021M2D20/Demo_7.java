package Y2021M2D20;
import java.util.Scanner;
public class Demo_7 {
	public static void main(String[] args) {
		//whileѭ�����䰸������������Ϸ
		Scanner scan = new Scanner(System.in);
		int number = (int)(Math.random()*100);
		int guess = scan.nextInt();
		while(guess != number) {
			if(guess > number) {
				System.out.println("����");
			} else {
				System.out.println("��С");
			}
			guess = scan.nextInt();
		}
		System.out.println("��ϲ��¶��ˣ�number="+number);
	}
}