package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 	泛型在集合当中的应用---约束集合中的元素类型
 * @author Grant·Vranes
 *
 */
public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		/*
		 * 	指定后add方法只能传入泛型要求的元素
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		System.out.println(c);
		
		/*
		 * 	新循环可以直接用实际类型接收元素
		 * 	实际上，新循环的本质就是下面的迭代器循环
		 */
		for(String str : c) {
			System.out.println(str);
		}
		
		/*
		 *	 迭代器也支持泛型，指定的类型与集合的泛型一致即可
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
	}
}
