package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	ʹ����ѭ����������
 * @author Grant��Vranes
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		System.out.println(c);
		/*
		 * 	��ѭ���������ϻᱻ��������Ϊʹ�õ���������������
		 * 	�ڱ����Ĺ�����ʱ����ͨ�����ϵķ�����ɾԪ�صġ�
		 */
		for(Object o : c) {
			String str = (String)o;
			System.out.println(str);
		}
	}
}