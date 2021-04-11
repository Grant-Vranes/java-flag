package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	java.util.Collection
 * 	����
 * 	�������������ƣ����Ա���һ��Ԫ�أ������ṩ�˲���
 * 	����Ԫ�ص���ط�����ʹ�ñ�ݡ�
 * 	Collection�ӿ������������������ӽӿڣ�
 * 	java.util.List:���ظ����ϣ��������򣬿���ͨ���±����Ԫ��
 * 	java.util.Set:�����ظ����ϣ�Ԫ���Ƿ��ظ�ʱ����Ԫ������equals�ȽϽ����ж���
 * @author Grant��Vranes
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/* 1)
		 * boolean add(E e)  E���൱��һ����������,����Objectһ��������ʲô���͵�Ԫ�ض����Է��뼯��
		 * ��ǰ��������Ӹ���Ԫ�أ�����Ԫ�سɹ�����򷵻�true
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		
		System.out.println(c);
		
		/*	1)
		 * 	int size()
		 * 	���ص�ǰ���ϵ�Ԫ�ظ���
		 * 
		 * 	ע�⣺size()��length()��������ͬ�ĸ��length���ص��ǳ��ȣ�
		 * 	size���ص��Ǹ����������ʼ��һ�������СΪ10����ֻ�����з���3��Ԫ�أ�
		 * 	length=10��size=3
		 * 	������û�г��ȣ�������Ԫ�ش�С���ı�ģ�����û�ж�Ӧ��length����
		 */
		int size = c.size();
		System.out.println("size:"+size);
	
		/*	3)
		 * 	boolean isEmpty()
		 * 	�жϵ�ǰ�����Ƿ�Ϊ�ռ�(�������κ�Ԫ��size=0)
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("isEmpty:"+isEmpty);
	
		/*	4)
		 * 	void clear()
		 * 	��յ�ǰ����
		 */
		c.clear();
		System.out.println(c);
	}
}
