package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 	���Ϲ�����:java.util.Collections
 * 	���ṩһ����̬������sort, ���Զ�List���Ͻ�����Ȼ���򣨴�С����
 * 	��ôΪʲô����Set�����أ�
 * 	��ΪSet������ļ��ϣ�����֮��������ģ�û�����塣��List�ǿ϶������
 * @author Grant��Vranes
 *
 */
public class SortListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}