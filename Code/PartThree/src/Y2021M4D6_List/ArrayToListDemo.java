package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 	数组转换为List集合
 * 	通过数组的：Arrays的静态方法asList可以
 * 	将一个数组转换为一个List
 * 
 * 	注意：只能数组转List，不能转Set。因为List和Set的本质区别是
 * 	List可重复，Set不可重复。（而有序和无序并不是这两者的区别），
 * 	一个数组中可能会有重复元素，所以只能转List
 * @author Grant·Vranes
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three"};
		//返回一个对应数组类型的集合
		List<String> list = Arrays.asList(array);
		System.out.println(list);//[one, two, three]
	
		/*
		 * 	数组转换的集合对其元素操作就是对原数组对应元素的操作
		 * 	所以使用set方法修改了list集合后，对应的原数组也发生
		 * 	相应变化。
		 * 
		 * 	注意：asList方法只适合转换成List之后进行读取的基本操作，
		 * 	虽然转成List集合了，但是底层依然是数组，转换的list只可用
		 * 	来做读取操作，想要修改是不行的
		 */
		list.set(1, "2");
		System.out.println(list);//[one, 2, three]
		System.out.println("array:" + Arrays.toString(array));//array:[one, 2, three]
		
		/*
		 * 	由于数组是定长的，所以不支持集合的增删操作，不然就会抛出异常
		 * 	因为增删就会对原数组扩容或者缩容，但其本质就是创建一个新数组。
		 */
		list.add("four");//UnsupportedOperationException
	
		/*
		 * 	将数组转换成集合本就是为了操作方便，现在不让增删。其实可以再创建一
		 * 	个集合，然后把转换后的集合赋给它。
		 * 	所有的集合都提供了一个参数为Collection的构造方法，作用是在创建
		 * 	当前集合的同时包含给定集合中的所有元素
		 */
		List<String> list2 = new ArrayList<String>(list);
		/*
		 * 	上面这句话就相当于
		 * 	List<String> list2 = new ArrayList<String>();
		 * 	list2.addAll(list);
		 * 	然后就可以对集合增删
		 */
	}
}
