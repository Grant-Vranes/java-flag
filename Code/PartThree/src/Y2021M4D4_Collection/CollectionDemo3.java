package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 	集合操作
 * @author Grant·Vranes
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();//List是可重复集合
		c1.add("java");
		c1.add("c");
		c1.add("c++");
		System.out.println("c1:"+c1);
		
		Collection c2 = new HashSet();//Set是不可重复集合
		c2.add("php");
		c2.add(".net");
		c2.add("java");
		System.out.println("c2:"+c2);
		
		/*	1)
		 * boolean addAll(Collection c)
		 * 	将给定集合中的所有元素添加到当前集合中
		 */
		
//		c1.addAll(c2);
//		System.out.println("并集c1:"+c1);
		//并集c1:[java, c, c++, java, php, .net]
		//List是允许存在重复的集合，所以才会出现两个java

		c2.addAll(c1);
		System.out.println("并集c2:"+c2);
		//并集c2:[c++, java, c, php, .net]
		//Set是不允许存在重复的集合，所以只会有一个java
		
		Collection c3 = new ArrayList();
		c3.add("c");
		c3.add(".net");
		
		/*	2)
		 *	boolean containsAll(Collection c)
		 *	判断当前集合是否包含给定集合中的所有元素 
		 */
		boolean ca = c2.containsAll(c3);
		System.out.println("c2是否全包含c3:"+ca);//true
	
		/*	3)
		 * 	boolean removeAll(Collection c)
		 * 	删除当前集合与给定集合的共有元素
		 */
		c2.removeAll(c3);
		System.out.println(c2);//[c++, java, php]
	}
}
