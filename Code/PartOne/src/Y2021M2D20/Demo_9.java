package Y2021M2D20;

public class Demo_9 {
	public static void main(String[] args) {
		//¾Å¾Å³Ë·¨±í
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j+"x"+i+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}
}
