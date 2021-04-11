package Y2021M4D10_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 	Map的遍历
 * 	遍历Map有三种方式
 * 	1：遍历所有的key
 * 	2：遍历每一组键值对
 * 	3：遍历所有的value(相对不常用)
 * @author Grant·Vranes
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 99);
		map.put("英语", 99);
		
		/*
		 * 	1)遍历所有的key
		 * 	Set<K> keySet() 方法     key不允许重复，用Set接收
		 * 	将当前Map中所有的key以一个Set集合形式返回。
		 * 	遍历这个集合就等同于遍历了所有的key
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key+":"+map.get(key));
		}
		
		/*
		 * 	2)遍历每一组键值对
		 * 	Set<Entry> entrySet() 方法
		 * 
		 * 	java.util.Map.Entry
		 * 	Entry的每一个实例用于表示当前Map中的一组键值对.
		 * 	其中由两个常用的方法：
		 * 	getKey(), getValue()分贝是用于获取对应的
		 * 	key和value
		 */
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> e : entrySet) {
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * 	3)遍历所有的value
		 * 	Collection<K> values() 方法
		 * 	value允许重复，用Collection接收
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values) {
			System.out.println("value:" + value);
		}
	}
}
