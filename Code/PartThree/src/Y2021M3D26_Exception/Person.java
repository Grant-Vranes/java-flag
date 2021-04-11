package Y2021M3D26_Exception;
/**
 * 	ʹ�õ�ǰ������쳣���׳�
 * @author Grant��Vranes
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	/*
	 * 	ͨ��һ��������ʹ��throw�׳�һ���쳣ʱ��Ҫ�ڷ�������ʱʹ��
	 * 	throws�������쳣���׳���֪ͨ�����߽�����쳣��
	 * 
	 * 	ֻ���׳�RuntimeException�����������쳣ʱ���Բ�Ҫ��������
	 */
	public void setAge(int age) throws IllegalAgeException {
		//��ʱ���㷽��������ʱ��throws���쳣�����ǵ������������Ҫ�����쳣��������Ȼ�ͻᱨ��
		if(age<0 || age>100) {
			throw new IllegalAgeException("���䲻�Ϸ�");
		}
		this.age = age;
	}
	
}