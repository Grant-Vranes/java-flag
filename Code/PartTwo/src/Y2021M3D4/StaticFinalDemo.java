package Y2021M3D4;
//static final ��ʾ
public class StaticFinalDemo {
	public static void main(String[] args) {
		System.out.println(Aoo.PI);//������������
		System.out.println(Boo.num);
		/*
		 * 1)����Boo.class������������
		 * 2)��̬����numҲ�洢����������
		 * 3)���������л�ȡnum�����
		 */
		System.out.println(Boo.COUNT);
		/*
		 * �������ڱ���ʱ������ֱ���滻Ϊ�����ֵ��Ч�ʸ�
		 * �൱��System.out.println(5);
		 */
	}

}

class Aoo{
	public static final double PI = 3.14159;
	//public static final int NUM;//�������
}
class Boo{
	public static int num = 5;//��̬������������ģ��洢�ڷ������У�ֻ��һ��
	public static final int COUNT = 5;//����
}