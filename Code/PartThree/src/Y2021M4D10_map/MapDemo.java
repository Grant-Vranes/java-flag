package Y2021M4D10_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 	java.util.Map
 * 	Map 查找表，结构看起来像是一个多行两列的表格。
 * 	左列称为key，右列称为value
 * 	所以Map总是以key-value对的形式保存元素。
 * 	并且总是根据key去获取对应的value
 * 	对此我们经常将“查询条件”作为key，将要查询的数据
 * 	作为value进行保存。
 * 	
 * 	Map本身是一个接口，规定了Map操作的相关方法。
 * 	常用实现类：java.util.HashMap
 * 
 * 	HashMap又称为散列表，哈希表
 * 	使用散列算法实现的Map，当今世界上查询速度最快的数据结构
 * @author Grant·Vranes
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		/*	1)存方法
		 *	V put(K k, V v)
		 *	将给定的一组键值对存入到Map中
		 *
		 *	Map有一个要求，即：key不允许重复，
		 *	是否重复是依靠key自身equals比较的结果。
		 *	如果使用map中已有的key保存value，则这个
		 *	操作 为替换value操作，那么这时put方法会将
		 *	被替换的value返回。如果不是做替换操作则
		 *	返回值为null
		 */
		map.put("语文", 99);
		map.put("数学", 99);
		Integer d = map.put("英语", 99);
		/*
		 * 	如果value是个包装类，那么接收时应当避免直接使用基本类型。
		 * 	因为这会导致自动拆箱，若没有做替换操作，返回的value就为
		 * 	null，这时对null拆箱就引发了空指针异常。
		 */
		System.out.println(d);//null
		System.out.println(map);//{数学=99, 语文=99, 英语=99}
		
		//替换操作的返回值为被替换的value
		d = map.put("语文",100);
		System.out.println(d);//99
		System.out.println(map);//{数学=99, 语文=100, 英语=99}
	
	
		/*	2)获取方法
		 * 	V get(Object key)
		 * 	根据给定的key获取对应的value，若给定的key不存在，则返回值为null
		 */
		d = map.get("数学");
		System.out.println("数学："+ d);//数学：99
		
		/*	3)元素（键值对）个数
		 * 	int size()
		 * 	获取Map中的元素个数，每组键值对算一个元素
		 */
		int size = map.size();
		System.out.println("size:"+size);//size:3
		
		/*	4)删除操作
		 * 	V remove(K k)
		 * 	将给定的key所对应的键值对删除，返回值为该key对应的value
		 */
		d = map.remove("语文");
		System.out.println(map);//{数学=99, 英语=99}
		System.out.println(d);//100
	}
}
