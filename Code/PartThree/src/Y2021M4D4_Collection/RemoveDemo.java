package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	删除集合元素
 * @author Grant·Vranes
 *
 */
public class RemoveDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(1,2));
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * 	删除元素也是依靠元素equals比较判定，所以Point类中也要重写equals方法
		 * 	只会删除找到的第一个元素
		 */
		c.remove(p);
		System.out.println(c);
	}
}
