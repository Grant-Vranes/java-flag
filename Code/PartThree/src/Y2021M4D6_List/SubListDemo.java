package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.List;

/**
 * 	��ȡ�Ӽ�����
 * 	List subLis(int start, int end)
 * 	��ȡ��ǰ����ָ���±��Ӧ��Χ�ڵ�Ԫ��(��ͷ����β)
 * 	ע�⣺���Ӽ��Ĳ���Ҳ��ӳ�䵽ԭ����
 * @author Grant��Vranes
 *
 */
public class SubListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		System.out.println(list);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList);//[3, 4, 5, 6, 7]
		
		/*
		 * 	���Ӽ�ÿ��Ԫ������10��
		 */
		for(int i=0; i<subList.size(); i++) {
			subList.set(i, subList.get(i)*10);
		}
		System.out.println(subList);//[30, 40, 50, 60, 70]
		/*
		 * 	�����Ӽ����Ƕ�ԭ���϶�ӦԪ�صĲ���
		 */
		System.out.println(list);//[0, 1, 2, 30, 40, 50, 60, 70, 8, 9]
	
		/*
		 * 	��list�������±�2~8��Ԫ��ɾ��
		 */
		list.subList(2, 9).clear();//ͨ ������������Կ���ɾ�������е�Ԫ��
		System.out.println(list);//[0, 1, 9]
	}
}