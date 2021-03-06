package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.List;

/**
 * 	List提供了一对重载的add,remove方法
 * @author Grant·Vranes
 *
 */
public class AddRemoveDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		/*
		 * 	void add(int index, E e)
		 * 	将给定元素插入到指定位置
		 */
		list.add(1, "2");
		System.out.println(list);//[one, 2, two, three]
		
		/*
		 * 	E remove(int index)
		 * 	删除并返回给定位置对应的元素
		 */
		String old = list.remove(2);
		System.out.println(list);//[one, 2, three]
		System.out.println(old);//two
		
	}
}
