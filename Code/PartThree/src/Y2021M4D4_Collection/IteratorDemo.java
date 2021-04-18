package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * 	�����ṩ��ͳһ�ı���Ԫ�ط�ʽ��������ģʽ
 * 
 * 	��Ӧ������
 * 	Iterator iterator()
 * 	�÷������Ի�ȡһ������������ǰ���ϵĵ�����ʵ���࣬ͨ����
 * 	����Ԫ��
 * 
 * 	java.util.Iterator�ӿ�
 * 	�������ӿڣ��涨�˵������������ϵ���ز�����ͬ�ļ��϶�
 * 	ʵ����һ�����ڱ�������Ԫ�صĵ�����ʵ���ࡣ
 * 
 * 	��������������Ԫ����ѭ�Ĺ��̣��ʣ�ȡ��ɾ
 * 	����ɾ���������Ǳ�Ҫ��
 * @author Grant��Vranes
 *
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		System.out.println(c);
		
		//��ȡ����c�ĵ�����
		Iterator it = c.iterator();
		/*
		 * 	boolean hasNext()
		 * 	�жϼ����Ƿ���Ԫ�ؿ��Ե���
		 */
		while(it.hasNext()) {
			/*
			 * 	E next()
			 * 	����������һ��Ԫ��
			 * 	�÷���һ�㷵��ֵ���Ƿ��ͣ������֪���������е�Ԫ��������ɶ������ֱ���ø����ͽ���
			 */
			//Object o = it.next();
			String o = (String)it.next();
			if("#".equals(o)) {//��#ȫ���ɵ�
				//c.remove(o);
				/*
				 * 	�����������������ǲ�����ʹ�ü��ϵķ���ȥɾ��Ԫ�ص�
				 *	ֻ���õ������Լ��ķ���ȥɾ��Ԫ��
				 *
				 * 	�������ɾ������ͨ��next����ȡ����Ԫ��
				 */
				it.remove();
			}
			System.out.println(o);
		}
	}
}