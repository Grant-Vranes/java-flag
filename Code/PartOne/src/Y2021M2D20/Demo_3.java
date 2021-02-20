package Y2021M2D20;

public class Demo_3 {
	public static void main(String[] args) {
		//逻辑运算符的短路效果
		
		
		int a = 5, b = 10, c = 5;
		boolean enp = a>b && c++>2;
		System.out.println(enp);//false
		System.out.println(c);//5,发生短路
		
		int a1 = 5, b1 = 10, c1 = 5;
		boolean enp1 = a<b || c1++>2;
		System.out.println(enp1);//true
		System.out.println(c1);//5,发生短路
		
	}
}
