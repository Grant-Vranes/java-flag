package Y2021M2D20;

public class Demo_12 {
	public static void main(String[] args) {
		//���������:ð������
		int[] arr = {67,23,4,56};
		for(int i = 0; i < arr.length-1; i++) {//��������
			for(int j = 0; j < arr.length-1-i;j++) {//���ƴ���,iÿ��һ�֣�һ���еıȽϴ�����һ��
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