package Y2021M2D20;

import java.util.Arrays;

public class Demo_11 {
	public static void main(String[] args) {
		//����ĸ���
		int[] a = {10,20,30,40,50};
		int[] a1 = new int[6];
		System.arraycopy(a,1,a1,0,4);
		/*
		 * a:Դ����
		 * 1:Դ�������ʼ�±�
		 * a1:Ŀ������
		 * 0:Ŀ���������ʼ�±�
		 * 4:Ҫ���Ƶ�Ԫ�ظ���
		 */
		for(int v : a1) {
			System.out.print(v+"\t");
		}
		
		System.out.println("\n----------------");
		
		int[] a2 = Arrays.copyOf(a, 8);//Ч�ʵͣ�����Բ�
		/*
		 * a:Դ����
		 * a2:Ŀ������
		 * 8:Ŀ�����鳤��
		 */
		for(int v:a2) {
			System.out.print(v+"\t");
		}
	}
}