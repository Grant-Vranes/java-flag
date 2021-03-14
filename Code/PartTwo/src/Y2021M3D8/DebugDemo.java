 package Y2021M3D8;

public class DebugDemo {
	public static void main(String[] args) {
		int a = 5;
		int b = 8;
		test();
		plus(a, b);
	}
	public static void test() {
		System.out.println(111);
		System.out.println(222);
		System.out.println(333);
	}
	public static void plus(int num1, int num2) {
		int num = num1+num2;
		if(num>10) {
			System.out.println(num);
		}
	}
}
