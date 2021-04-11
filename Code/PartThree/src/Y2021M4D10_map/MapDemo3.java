package Y2021M4D10_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 	判断Map是否包含给定元素。
 * 	可以分别判断是否包含key和value
 * 	boolean containsKey(Object k)
 * 	boolean containsValue(Object v)
 * @author Grant·Vranes
 *
 */
public class MapDemo3 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 99);
		map.put("英语", 99);
		
		boolean ck = map.containsKey("语文");
		System.out.println("包含key："+ck);//true
		
		boolean cv = map.containsValue(99);
		System.out.println("包含value："+cv);//true
		
		/*
		 * 	注意：这两种方法判断包含的时候都是根据equals方法进行判断的
		 * 	如果再使用自定义类型元素的时候，一定要妥善重写equals
		 */
	}
}
