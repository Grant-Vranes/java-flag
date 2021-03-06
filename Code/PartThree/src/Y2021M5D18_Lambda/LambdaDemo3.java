package Y2021M5D18_Lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	JDK8之后集合和Map都支持了一个新的方法：
 * 	forEach，可以使用 lambda遍历集合元素。
 * 	由于该方法是集合自行提供的，那么在使用一个线程安全
 * 	的集合或Map时，该种遍历方式也是并发安全的（原迭代
 * 	器模式不与集合方法互斥，并发需要自行维护）
 * @author Grant·Vranes
 *
 */
public class LambdaDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("three");
		list.add("two");
		list.add("four");
		for(String str : list) {
			System.out.println(str);
		}
		
		//JDK8支持的新方式
		list.forEach(
			(str)->System.out.println(str)
		);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		
		map.forEach(
			(k,v)->System.out.println(k + ":" + v)
		);
	}
}
