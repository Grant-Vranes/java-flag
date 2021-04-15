package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 	����ת��Ϊ����
 * 	�����ṩ��һ��������toArray�����Խ���ǰ����ת��Ϊһ������
 * @author Grant��Vranes
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		
		/*
		 * 	�����ôд�Ļ�������ֵ����һ����Object
		 * 	��JDK1.5֮ǰֻ�����������c.toArray()ֻ����object���ͽ���
		 */
		//Object[] array = c.toArray();
		
		/*
		 * 	JDK1.5�汾֮���Ƴ��˷��͵ĸ���������·�������ʹ��
		 * 	T[] toArray(T[] a)
		 * 	��Ҫ������toArray()�������д����������
		 * 
		 * 	new String[c.size()]��Ϊ��ȷ������ֵ���ͺʹ�С��������ݳ��ȸ����ˣ���Ķ����null
		 * 	������鳤�ȸ�С�ˣ������Զ�����һ��ͬ���͵����飬����
		 */
		String[] array = c.toArray(new String[c.size()]);
		System.out.println(Arrays.toString(array));
	}
}
