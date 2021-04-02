package Y2021M3D24_IO;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 	ʹ�õ�ǰ��ʵ�����Զ������Ķ����д����
 * 
 * 	��һ�����ʵ��ϣ�����Ա����������ж�д����ô
 * 	�������ʵ�֣�java.io.Serializable�ӿ�
 * 	���ͬʱ����ǰ���������������͵����ԣ����Ƕ�Ӧ����Ҳ����ʵ�ָýӿ�
 * 	
 * 	ʵ�ָýӿڱ�ʾ������Ա����л�
 * 
 * 	һ��ʵ�ֽӿ�һ��Ҫ��д�䷽��������ʵ������ӿ��в���Ҫ��
 * 	��Ϊ����һ��ǩ���ӿڣ�����û���κη���
 * @author Grant��Vranes
 *
 */
public class Person implements Serializable{
	/**
	 * 	��һ����ʵ����Serializable�ӿں�Ҫ��Ӧ������һ������
	 * 	serialVersionUID���������л��汾��
	 * 
	 * 	���л��汾��Ӱ�췴���л��Ƿ�ɹ����������������ڽ��ж�����
	 * 	�л�ʱ����ö����뵱ǰ��İ汾�Ƿ�һ�£���һ�������л�ʱ
	 * 	���׳��쳣���·����л�ʧ�ܡ�
	 * 	һ������Խ��з����л���ԭ���Ƕ�Ӧ�����Խ��л�ԭ��
	 * 
	 * 	������ǲ�����ð汾�ţ����������ڱ��뵱ǰ��ʱ���ݽṹ����һ
	 * 	���汾�ţ���ô�汾��һ����ı䡣������ǰ�Ķ���һ���ǲ����Է����л���
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * transient�ؼ������ε������ڶ������л�ʱ�ᱻ���ԡ�
	 *	 ���Բ���Ҫ�����Կ��Դﵽ�������������
	 */
	private transient String[] otherInfo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String[] otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	//��дtoString����
	public String toString() {
		return name+","+age+","+gender+","+Arrays.toString(otherInfo);
	}
	
}
