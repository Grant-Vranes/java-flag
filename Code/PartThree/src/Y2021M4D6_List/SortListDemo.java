package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 	集合工具类:java.util.Collections
 * 	其提供一个静态方法：sort, 可以对List集合进行自然排序（从小到大）
 * 	那么为什么不对Set排序呢？
 * 	因为Set是无序的集合，排了之后还是无序的，没有意义。但List是肯定有序的
 * @author Grant·Vranes
 *
 */
public class SortListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
