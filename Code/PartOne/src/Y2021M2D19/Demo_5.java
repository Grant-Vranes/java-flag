package Y2021M2D19;

public class Demo_5 {
	public static void main(String[] args) {
		//�����������ͼ��ת����
		int a = 5;
		long b = a;//�Զ�����ת��
		int c = (int)b;//ǿ������ת��
		
		long d = 5;//�Զ�����ת��
		double e = 5;//�Զ�����ת��
		System.out.println(e);//5.0
		
		long f = 10000000000L;
		int g = (int)f;
		System.out.println(g);//ǿת�п������
		
		double h = 25.8716;
		int i = (int)h;
		System.out.println(i);//ǿת�п��ܶ�ʧ����
	}
}
