package Y2021M2D19;

public class Demo_3 {
	public static void main(String[] args) {
		//int
		int a = 266;
		int b= 2147483647;//���ֵ
		System.out.println(5/2.0);
		
		//long
		//long c = 10000000000;//�������100��Ĭ��Ϊint����
		long d = 10000000000L;//100��LΪ������ֱ����
		
		long e = 1000000000*2*10L;
		System.out.println(e);//200��
		long f = 1000000000*3*10L;
		System.out.println(f);//���
		long g = 1000000000L*3*10;
		System.out.println(g);
		long h = System.currentTimeMillis();
		System.out.println(h);
		
		//double
		double pi = 3.14159;//������ֱ����Ĭ��Ϊdouble
		float pi1 = 3.14159F;
		double a1 = 6.0,b1 = 2.9;
		System.out.println(a1-b1);
	}
}
