package Y2021M2D20;

import java.util.Scanner;

public class Demo_4 {
	/**
	 * ������ж�
	 * �жϹ�ʽ��
	 * 1���ܱ�4���������ң����ܱ�100����
	 * ����
	 * 2���ܱ�400����
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������");
		int year = scan.nextInt();
		boolean flag = (year%4==0 && year%100 != 0) || year%400==0;
		String str = flag ? year+"������" : year+"��������";
		System.out.println(str);
	}
}
