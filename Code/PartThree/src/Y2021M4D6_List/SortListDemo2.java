package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 	�����Զ�������Ԫ��
 * @author Grant��Vranes
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(3,4));
		list.add(new Point(5,6));
		list.add(new Point(3,8));
		list.add(new Point(2,7));
		System.out.println(list);
		/*
		 * 	Collections��sort��������ļ���Ҫ��Ԫ�ر���ʵ��Comparable�ӿ�
		 * 	Ȼ����дcompareTo�������ڷ����ж���ȽϵĹ���
		 * 
		 * 	����������Զ�������Ԫ�أ�ǿ�ҽ��鲻ʹ�����ַ�ʽ����Ϊ���sort��������
		 * 	�ǵĴ����������ԣ���Ҫ��Point����Ϊ��ʵ�ֽӿڣ�����д�������ĵ�Խ�������Ծ�Խǿ��
		 * 	����java API�кܶ����Ѿ�ʵ���˸ýӿڣ������װ�࣬String�ȣ���ô����������Ԫ��
		 * 	�ļ���ʱ����ֱ���� �������sort
		 */
		Collections.sort(list);
		System.out.println(list);
	}
}
