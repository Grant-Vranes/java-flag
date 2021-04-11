package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	 集合提供了判断是否包含给定元素的方法：
 * 	boolean contains(E e)
 * @author Grant·Vranes
 *
 */
public class ContainsDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		c.add(new Point(9,10));
		/*
		 * 集合的toString方法会将每个元素的toString体现出来
		 * 如果Point类中没有重写toString方法的话，这里输出的
		 * 也不好看
		 */
		System.out.println(c);
		//[(1, 2), (3, 4), (5, 6), (7, 8), (9, 10)]
	
		Point p = new Point(1,2);
		//c.add(p);
		/*
		 * 	 contains方法是依靠元素自身equals比较
		 * 	 的结果判别集合是否包含该元素，但默认的equals
		 * 	方法都是==，不能进行准确判定，所以要重写equals方法
		 */
		boolean contains = c.contains(p);
		System.out.println("包含："+contains);//true
	}
}
