package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.List;

/**
 * 	java.util.List接口
 * 	List继承自Collection
 * 	List的特点：可重复，并且有序，提供了一组可以通过下标操作元素的方法
 * 
 * 	常用实现类：
 * 	java.util.ArrayList:内部由数组实现，查询性能更好。
 * 	java.util.LinkedList:内部由链表实现，增删元素性能更好，尤其首尾增删元素。
 * 	
 * 	在对性能没有特别苛刻要求下，通常使用的是ArrayList即可。
 * @author Grant·Vranes
 *
 */
public class GetSetDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		
		/*
		 * 	E get(int index)
		 * 	获取给定下标对应的元素
		 */
		String str = list.get(1);//two
		System.out.println(str);
		//List可以用普通的for循环遍历
		for(int i=0; i<list.size(); i++) {
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * 	E set(int index, E e)
		 * 	将给定元素设置到指定位置，返回值为原位置对应元素。所以set方法的
		 * 	意义是替换元素操作，并且它只能在已有元素上操作，不能越界。
		 */
		String old = list.set(1, "2");
		System.out.println(list);//[one, 2, three]
		System.out.println(old);//two
		
	}
}
