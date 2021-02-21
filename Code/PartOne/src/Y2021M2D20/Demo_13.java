package Y2021M2D20;

import java.util.Arrays;

public class Demo_13 {
	public static void main(String[] args) {
		//找到数组元素的最小值，并放在第一位
		//1、随机生成十位数
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.print(arr[i]+"\t");
		}
		
		//2、找出最小值
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("min = " + min);
		
		//3、定义一个新数组，旧数组复制到新数组1的位置
		int[] as = new int[arr.length+1];
		System.arraycopy(arr, 0, as, 1, arr.length);
		as[0] = min;
		for(int v : as) {
			System.out.print(v + "\t");
		}
		
		//第三步可以用Arrays.copyOf()进行数组扩容,但这种方法只能在数组末尾加一个位置
		//arr = Arrays.copyOf(arr, arr.length+1);
	}
}
