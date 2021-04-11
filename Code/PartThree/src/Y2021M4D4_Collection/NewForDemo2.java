package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	使用新循环遍历集合
 * @author Grant·Vranes
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		System.out.println(c);
		/*
		 * 	新循环遍历集合会被编译器改为使用迭代器遍历。所以
		 * 	在遍历的过程中时不能通过集合的方法增删元素的。
		 */
		for(Object o : c) {
			String str = (String)o;
			System.out.println(str);
		}
	}
}
