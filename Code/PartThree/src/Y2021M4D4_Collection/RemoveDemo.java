package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	ɾ������Ԫ��
 * @author Grant��Vranes
 *
 */
public class RemoveDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(1,2));
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * 	ɾ��Ԫ��Ҳ������Ԫ��equals�Ƚ��ж�������Point����ҲҪ��дequals����
		 * 	ֻ��ɾ���ҵ��ĵ�һ��Ԫ��
		 */
		c.remove(p);
		System.out.println(c);
	}
}
