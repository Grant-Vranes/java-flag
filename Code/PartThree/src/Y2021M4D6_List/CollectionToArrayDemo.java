package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 	集合转换为数组
 * 	集合提供了一个方法：toArray，可以将当前集合转换为一个数组
 * @author Grant·Vranes
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		
		/*
		 * 	如果这么写的话，返回值类型一定是Object
		 */
		//Object[] array = c.toArray();
		
		/*
		 * 	new String[c.size()]是为了确定返回值类型和大小，如果数组长度给小了
		 * 	他会自动创建一个同类型的数组，返回
		 */
		String[] array = c.toArray(new String[c.size()]);
		System.out.println(Arrays.toString(array));
	}
}
