package Y2021M2D19;

public class Demo_5 {
	public static void main(String[] args) {
		//基本数据类型间的转换：
		int a = 5;
		long b = a;//自动类型转换
		int c = (int)b;//强制类型转换
		
		long d = 5;//自动类型转换
		double e = 5;//自动类型转换
		System.out.println(e);//5.0
		
		long f = 10000000000L;
		int g = (int)f;
		System.out.println(g);//强转有可能溢出
		
		double h = 25.8716;
		int i = (int)h;
		System.out.println(i);//强转有可能丢失精度
	}
}
