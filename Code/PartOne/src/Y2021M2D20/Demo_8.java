package Y2021M2D20;

import java.util.Scanner;

public class Demo_8 {
	/**
	 * forѭ�����䰸��������ӷ�������
  		1������һ�γ�10���ӷ���Ŀ�����û�������Ŀ�Ĵ�
    	2���û�ÿ����һ���⣬�����ж϶Դ�����ʾ����ԡ��򡰴��
    	3��10����Ŀ����֮��ϵͳ����÷ֲ����
    	4��ϣ���û���ǰ��������������-1��ǰ�˳�
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0;
		for (int i = 1; i <= 10; i++) {
			//1������		2������	3������
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
		System.out.println("�÷�Ϊ"+score);
	}
}
