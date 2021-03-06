package Y2021M2D20;

import java.util.Arrays;

public class Demo_11 {
	public static void main(String[] args) {
		//数组的复制
		int[] a = {10,20,30,40,50};
		int[] a1 = new int[6];
		System.arraycopy(a,1,a1,0,4);
		/*
		 * a:源数组
		 * 1:源数组的起始下标
		 * a1:目标数组
		 * 0:目标数组的起始下标
		 * 4:要复制的元素个数
		 */
		for(int v : a1) {
			System.out.print(v+"\t");
		}
		
		System.out.println("\n----------------");
		
		int[] a2 = Arrays.copyOf(a, 8);//效率低，灵活性差
		/*
		 * a:源数组
		 * a2:目标数组
		 * 8:目标数组长度
		 */
		for(int v:a2) {
			System.out.print(v+"\t");
		}
	}
}
