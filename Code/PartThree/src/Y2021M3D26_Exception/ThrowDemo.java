package Y2021M3D26_Exception;
/**
 * 	�����쳣���׳�
 * @author Grant��Vranes
 *
 */
public class ThrowDemo {
	public static void main(String[] args) {
		Person p = new Person();
		/*
		 * 	�����﷨����������ҵ���߼�Ҫ����ʱsetAge�����п��Ե����쳣�׳�
		 * 	Ҫ���������ʱȥ�����쳣
		 * 
		 * 	������һ������throws�����쳣�׳��ķ���ʱ��Ҫ����봦����쳣
		 * 	������ķ�ʽ�����֣�
		 * 	1��ʹ��try-catch���񲢽���쳣
		 * 	2���ٵ�ǰ�����ϼ���ʹ��throws�������쳣���׳�
		 * 	ע�⣺һ�㲻Ҫ��main������throws�쳣�����Ǽ��䲻�����εı���
		 */
		try {
			p.setAge(10000);
		} catch (IllegalAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p.getAge());
	}
}
