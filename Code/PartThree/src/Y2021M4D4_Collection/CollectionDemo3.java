package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 	���ϲ���
 * @author Grant��Vranes
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();//List�ǿ��ظ�����
		c1.add("java");
		c1.add("c");
		c1.add("c++");
		System.out.println("c1:"+c1);
		
		Collection c2 = new HashSet();//Set�ǲ����ظ�����
		c2.add("php");
		c2.add(".net");
		c2.add("java");
		System.out.println("c2:"+c2);
		
		/*	1)
		 * boolean addAll(Collection c)
		 * 	�����������е�����Ԫ����ӵ���ǰ������
		 */
		
//		c1.addAll(c2);
//		System.out.println("����c1:"+c1);
		//����c1:[java, c, c++, java, php, .net]
		//List����������ظ��ļ��ϣ����ԲŻ��������java

		c2.addAll(c1);
		System.out.println("����c2:"+c2);
		//����c2:[c++, java, c, php, .net]
		//Set�ǲ���������ظ��ļ��ϣ�����ֻ����һ��java
		
		Collection c3 = new ArrayList();
		c3.add("c");
		c3.add(".net");
		
		/*	2)
		 *	boolean containsAll(Collection c)
		 *	�жϵ�ǰ�����Ƿ�������������е�����Ԫ�� 
		 */
		boolean ca = c2.containsAll(c3);
		System.out.println("c2�Ƿ�ȫ����c3:"+ca);//true
	
		/*	3)
		 * 	boolean removeAll(Collection c)
		 * 	ɾ����ǰ������������ϵĹ���Ԫ��
		 */
		c2.removeAll(c3);
		System.out.println(c2);//[c++, java, php]
	}
}
