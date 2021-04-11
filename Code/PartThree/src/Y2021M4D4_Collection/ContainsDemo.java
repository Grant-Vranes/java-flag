package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	 �����ṩ���ж��Ƿ��������Ԫ�صķ�����
 * 	boolean contains(E e)
 * @author Grant��Vranes
 *
 */
public class ContainsDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		c.add(new Point(9,10));
		/*
		 * ���ϵ�toString�����Ὣÿ��Ԫ�ص�toString���ֳ���
		 * ���Point����û����дtoString�����Ļ������������
		 * Ҳ���ÿ�
		 */
		System.out.println(c);
		//[(1, 2), (3, 4), (5, 6), (7, 8), (9, 10)]
	
		Point p = new Point(1,2);
		//c.add(p);
		/*
		 * 	 contains����������Ԫ������equals�Ƚ�
		 * 	 �Ľ���б𼯺��Ƿ������Ԫ�أ���Ĭ�ϵ�equals
		 * 	��������==�����ܽ���׼ȷ�ж�������Ҫ��дequals����
		 */
		boolean contains = c.contains(p);
		System.out.println("������"+contains);//true
	}
}
