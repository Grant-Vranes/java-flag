package Y2021M2D20;

public class Demo_10 {
	public static void main(String[] args) {
		//数组案例：找出数组中的最大值
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.print(arr[i] + " ");
		}
		
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("\n"+max);
	}
}
