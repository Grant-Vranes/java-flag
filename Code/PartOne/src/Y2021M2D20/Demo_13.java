package Y2021M2D20;

import java.util.Arrays;

public class Demo_13 {
	public static void main(String[] args) {
		//�ҵ�����Ԫ�ص���Сֵ�������ڵ�һλ
		//1���������ʮλ��
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.print(arr[i]+"\t");
		}
		
		//2���ҳ���Сֵ
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("min = " + min);
		
		//3������һ�������飬�����鸴�Ƶ�������1��λ��
		int[] as = new int[arr.length+1];
		System.arraycopy(arr, 0, as, 1, arr.length);
		as[0] = min;
		for(int v : as) {
			System.out.print(v + "\t");
		}
		
		//������������Arrays.copyOf()������������,�����ַ���ֻ��������ĩβ��һ��λ��
		//arr = Arrays.copyOf(arr, arr.length+1);
	}
}
