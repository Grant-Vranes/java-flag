package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	面试题
 * @author Grant·Vranes
 *
 */
public class Test {
	public static void main(String[] args) {
		int a = 1;
		String b = "hello";
		Point p = new Point(1,2);
		Collection c = new ArrayList();
		c.add(p);
		test(a, b, p, c);
		System.out.println("a:"+a);//1
		System.out.println("b:"+b);//hello
		System.out.println("p:"+p);//(3,2)
		System.out.println("c:"+c);//[(5,7)]
	}
	public static void test(int a, String b, Point p, Collection c) {
		a = 2;
		b = b + "world";
		p.setX(3);
		p = new Point(5,6);
		c.clear();//清空集合c中的引用
		c.add(p);//把test对象新new出来的对象的引用存入集合c
		p.setY(7);
		c = new ArrayList();
		c.add(p);
	}
}
