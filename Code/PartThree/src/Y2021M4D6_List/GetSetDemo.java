package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.List;

/**
 * 	java.util.List�ӿ�
 * 	List�̳���Collection
 * 	List���ص㣺���ظ������������ṩ��һ�����ͨ���±����Ԫ�صķ���
 * 
 * 	����ʵ���ࣺ
 * 	java.util.ArrayList:�ڲ�������ʵ�֣���ѯ���ܸ��á�
 * 	java.util.LinkedList:�ڲ�������ʵ�֣���ɾԪ�����ܸ��ã�������β��ɾԪ�ء�
 * 	
 * 	�ڶ�����û���ر����Ҫ���£�ͨ��ʹ�õ���ArrayList���ɡ�
 * @author Grant��Vranes
 *
 */
public class GetSetDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		
		/*
		 * 	E get(int index)
		 * 	��ȡ�����±��Ӧ��Ԫ��
		 */
		String str = list.get(1);//two
		System.out.println(str);
		//List��������ͨ��forѭ������
		for(int i=0; i<list.size(); i++) {
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * 	E set(int index, E e)
		 * 	������Ԫ�����õ�ָ��λ�ã�����ֵΪԭλ�ö�ӦԪ�ء�����set������
		 * 	�������滻Ԫ�ز�����������ֻ��������Ԫ���ϲ���������Խ�硣
		 */
		String old = list.set(1, "2");
		System.out.println(list);//[one, 2, three]
		System.out.println(old);//two
		
	}
}