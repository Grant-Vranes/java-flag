package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	集合只能存放引用类型元素，而不能存放基本类型元素，并且存放的也是元素的引用(地址)
 * @author Grant·Vranes
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Point p = new Point(1,2);
		
		c.add(p);
		System.out.println("c:"+c);//[(1, 2)]
		System.out.println("p:"+p);//(1, 2)
		
		p.setX(2);//此处修改p对象的x值，结果发现集合中元素也跟着变动了，说明集合c中存放的只是p对象的引用
		System.out.println("c:"+c);//[(2, 2)]
		System.out.println("p:"+p);//(2, 2)
	}
}
