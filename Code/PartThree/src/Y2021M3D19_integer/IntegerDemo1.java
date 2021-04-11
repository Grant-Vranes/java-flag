package Y2021M3D19_integer;
/**
 *	��װ��
 *	��װ����Ϊ�˽���������Ͳ���ֱ�Ӳ���������󿪷�������
 *	����6���������͵İ�װ��̳���Number��
 *	java.lang.Number��һ�������࣬�����˼������󷽷�
 *	Ҫ���������͵İ�װ����Խ����ʾ�������������������ͷ���
 */
public class IntegerDemo1{
	public static void main(String[] args) {
		int d = 1;
		//��������ת���ɰ�װ�಻��Java�Ƽ��ķ���
		Integer i1 = new Integer(d);
		Integer i2 = new Integer(d);
		
		System.out.println(i1==i2);//false
		System.out.println(i1.equals(i2));//true
		
		//java���Ƽ�ʹ��Integer.valueOf()ת����װ��
		Integer i3 = Integer.valueOf(d);
		Integer i4 = Integer.valueOf(d);
		
		System.out.println(i3==i4);//true
		System.out.println(i3.equals(i4));//true
	
		/*
		 *	 ��װ��ת��Ϊ��������
		 */
		d = i1.intValue();
		System.out.println(d);
		
		/*
		 *	�������͵İ�װ�඼��������������
		 *  MAX_VALUE
		 *  MIN_VALUE
		 * 	���ڱ�ʾ�ð�װ���Ӧ�Ļ������͵�ȡֵ��Χ
		 */
		int imax = Integer.MAX_VALUE;
		System.out.println(imax);
		int imin = Integer.MIN_VALUE;
		System.out.println(imin);
	}
}
