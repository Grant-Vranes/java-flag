package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	����ֻ�ܴ����������Ԫ�أ������ܴ�Ż�������Ԫ�أ����Ҵ�ŵ�Ҳ��Ԫ�ص�����(��ַ)
 * @author Grant��Vranes
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Point p = new Point(1,2);
		
		c.add(p);
		System.out.println("c:"+c);//[(1, 2)]
		System.out.println("p:"+p);//(1, 2)
		
		p.setX(2);//�˴��޸�p�����xֵ��������ּ�����Ԫ��Ҳ���ű䶯�ˣ�˵������c�д�ŵ�ֻ��p���������
		System.out.println("c:"+c);//[(2, 2)]
		System.out.println("p:"+p);//(2, 2)
	}
}
