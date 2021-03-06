package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 	排序字符串
 * @author Grant·Vranes
 *
 */
public class SortListDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("方天画戟");
		list.add("长矛");
		list.add("三胜鞭");
		System.out.println(list);
		//如果我想根据字符长度排序
		
		/*
		 * 	String已经实现了Comparable接口，比较规则为按照每个字符的
		 * 	Unicode编码比较。
		 * 	对于排序中文时，没有什么意义。
		 * 
		 * 	对此，该sort方法的使用相对局限
		 * 	所以当：
		 * 	排序自定义类型元素或java提供的已经实现过Comparable接口的元素
		 * 	但是比较方法不满足我们排序需求时，都不应当使用下面的sort方法
		 */
		Collections.sort(list);
		System.out.println(list);//[三胜鞭, 方天画戟, 长矛]
		
		/*
		 * 	Collections提供了一个重载的sort方法，该方法除了要求传入要排序的
		 * 	集合外，还要求再传入一个比较器（Comparator），该比较器可以定义一种 
		 * 	比较规则，该sort方法会用这个比较规则对集合元素比较后进行排序。
		 */
		 Collections.sort(list, new Comparator<String>() {
			 public int compare(String o1, String o2) {
				 //按照字符长度比较大小
				 return o1.length() - o2.length(); 
			 }
		 	}
		 );  
		 System.out.println(list);//[长矛, 三胜鞭, 方天画戟]
	}
}
