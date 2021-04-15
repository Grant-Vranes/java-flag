package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 	�����ڼ��ϵ��е�Ӧ��---Լ�������е�Ԫ������
 * @author Grant��Vranes
 *
 */
public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		/*
		 * 	ָ����add����ֻ�ܴ��뷺��Ҫ���Ԫ��
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		System.out.println(c);
		
		/*
		 * 	��ѭ������ֱ����ʵ�����ͽ���Ԫ��
		 * 	ʵ���ϣ���ѭ���ı��ʾ�������ĵ�����ѭ��
		 */
		for(String str : c) {
			System.out.println(str);
		}
		
		/*
		 *	 ������Ҳ֧�ַ��ͣ�ָ���������뼯�ϵķ���һ�¼���
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
	}
}
