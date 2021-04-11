package Y2021M4D4_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 	java.util.Collection
 * 	集合
 * 	集合与数组相似，可以保存一组元素，并且提供了操作
 * 	集合元素的相关方法，使用便捷。
 * 	Collection接口下面右两个常见的子接口：
 * 	java.util.List:可重复集合，并且有序，可以通过下标操作元素
 * 	java.util.Set:不可重复集合，元素是否重复时依靠元素自身equals比较进行判定的
 * @author Grant·Vranes
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/* 1)
		 * boolean add(E e)  E就相当于一个数据类型,就向Object一样，基本什么类型的元素都可以放入集合
		 * 向当前集合中添加给定元素，当该元素成功添加则返回true
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		
		System.out.println(c);
		
		/*	1)
		 * 	int size()
		 * 	返回当前集合的元素个数
		 * 
		 * 	注意：size()和length()是两个不同的概念，length返回的是长度，
		 * 	size返回的是个数，如果初始化一个数组大小为10，但只往其中放了3个元素，
		 * 	length=10，size=3
		 * 	但集合没有长度，是随着元素大小而改变的，所以没有对应的length方法
		 */
		int size = c.size();
		System.out.println("size:"+size);
	
		/*	3)
		 * 	boolean isEmpty()
		 * 	判断当前集合是否为空集(不含有任何元素size=0)
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("isEmpty:"+isEmpty);
	
		/*	4)
		 * 	void clear()
		 * 	清空当前集合
		 */
		c.clear();
		System.out.println(c);
	}
}
