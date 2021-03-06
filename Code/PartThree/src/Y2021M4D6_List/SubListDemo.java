package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.List;

/**
 * 	获取子集操作
 * 	List subLis(int start, int end)
 * 	获取当前集合指定下标对应范围内的元素(含头不含尾)
 * 	注意：对子集的操作也会映射到原集合
 * @author Grant·Vranes
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
		 * 	将子集每个元素扩大10倍
		 */
		for(int i=0; i<subList.size(); i++) {
			subList.set(i, subList.get(i)*10);
		}
		System.out.println(subList);//[30, 40, 50, 60, 70]
		/*
		 * 	操作子集就是对原集合对应元素的操作
		 */
		System.out.println(list);//[0, 1, 2, 30, 40, 50, 60, 70, 8, 9]
	
		/*
		 * 	将list集合中下标2~8的元素删除
		 */
		list.subList(2, 9).clear();//通 过这个操作可以快速删除集合中的元素
		System.out.println(list);//[0, 1, 9]
	}
}
