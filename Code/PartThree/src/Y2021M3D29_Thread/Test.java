package Y2021M3D29_Thread;

import java.util.Scanner;


/**
 * 	����ʱ����
 * 	����������Ҫ������һ�����֣�����:100
 * 	Ȼ��ÿ�����һ�Σ�ÿ��������ֵݼ�
 * 	�����0ʱ��ʾ�����������˳���
 * @author Grant��Vranes
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ������:");
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
		System.out.println("����ʱ������");
		
	}
}