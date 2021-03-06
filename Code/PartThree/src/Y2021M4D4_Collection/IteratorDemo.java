package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * 	集合提供了统一的遍历元素方式：迭代器模式
 * 
 * 	对应方法：
 * 	Iterator iterator()
 * 	该方法可以获取一个用来遍历当前集合的迭代器实现类，通过它
 * 	遍历元素
 * 
 * 	java.util.Iterator接口
 * 	迭代器接口，规定了迭代器遍历集合的相关操作不同的集合都
 * 	实现了一个用于遍历自身元素的迭代器实现类。
 * 
 * 	迭代器遍历集合元素遵循的过程：问，取，删
 * 	其中删除操作不是必要的
 * @author Grant·Vranes
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
		
		//获取集合c的迭代器
		Iterator it = c.iterator();
		/*
		 * 	boolean hasNext()
		 * 	判断集合是否还有元素可以迭代
		 */
		while(it.hasNext()) {
			/*
			 * 	E next()
			 * 	迭代集合下一个元素
			 * 	该方法一般返回值都是泛型，但如果知道迭代器中的元素类型是啥，可以直接用该类型接受
			 */
			//Object o = it.next();
			String o = (String)it.next();
			if("#".equals(o)) {//将#全部干掉
				//c.remove(o);
				/*
				 * 	迭代器遍历过程中是不允许使用集合的方法去删除元素的
				 *	只能用迭代器自己的方法去删除元素
				 *
				 * 	这个方法删除的是通过next方法取出的元素
				 */
				it.remove();
			}
			System.out.println(o);
		}
	}
}
