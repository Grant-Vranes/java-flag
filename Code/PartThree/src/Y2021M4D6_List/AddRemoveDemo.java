package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.List;

/**
 * 	List�ṩ��һ�����ص�add,remove����
 * @author Grant��Vranes
 *
 */
public class AddRemoveDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		/*
		 * 	void add(int index, E e)
		 * 	������Ԫ�ز��뵽ָ��λ��
		 */
		list.add(1, "2");
		System.out.println(list);//[one, 2, two, three]
		
		/*
		 * 	E remove(int index)
		 * 	ɾ�������ظ���λ�ö�Ӧ��Ԫ��
		 */
		String old = list.remove(2);
		System.out.println(list);//[one, 2, three]
		System.out.println(old);//two
		
	}
}