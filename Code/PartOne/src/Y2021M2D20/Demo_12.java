package Y2021M2D20;

public class Demo_12 {
	public static void main(String[] args) {
		//数组的排序:冒泡排序
		int[] arr = {67,23,4,56};
		for(int i = 0; i < arr.length-1; i++) {//控制轮数
			for(int j = 0; j < arr.length-1-i;j++) {//控制次数,i每加一轮，一轮中的比较次数少一次
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for (int v:arr) {
			System.out.print(v+"\t");
		}
	}
}
