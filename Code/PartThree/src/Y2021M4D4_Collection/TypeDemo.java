package Y2021M4D4_Collection;
/**
 * 	���Է���
 *	�����Ǳ������Ͽɵģ����������JVM
 * 	�������Ὣ���͸�ΪObject�����Է��͵�ʵ�����;���Object
 * 	��ʹ�÷���ʱ���������Ḩ������������
 * 	1���Է�������ֵʱ�������������ֵ�������Ƿ��뷺��һ�£�
 * 		��һ������벻ͨ��
 * 	2���ڻ�ȡ����ֵʱ��������������������͵Ĵ��롣
 * @author Grant��Vranes
 *
 */
public class TypeDemo {
	public static void main(String[] args) {
		//�Լ���<>�ж�����Ҫʹ�õ�����
		Location<Integer> loc1 = new Location<Integer>(1,2);
		loc1.setX(2);
		int x1 = loc1.getX();
		System.out.println("loc1:"+loc1);//loc1:(x=2, y=2)
		System.out.println("x1:"+x1);//x1:2
		
		Location<Double> loc2 = new Location(3.0, 5.0);
		loc2.setX(7.0);
		double x2 = loc2.getX();
		System.out.println("loc2:"+loc2);//loc2:(x=7.0, y=5.0)
		System.out.println("x2:"+x2);//x2:7.0
	}
}
