package Y2021M5D18_Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("近朱者赤近墨者黑");
		list.add("时间");
		list.add("空间几何");
		System.out.println(list);
		//比较器写法
//		Comparator<String> com = new Comparator<String>() {
//			public int compare(String o1, String o2) {
//				return o1.length()-o2.length();
//			}
//		};
		
		/*
		 * 	方法中的参数类型可以不再指定，编译器会结合程序自行分析参数类型
		 */
//		Comparator<String> com = (o1, o2)->{
//			return o1.length()-o2.length();
//		};
		
		/*
		 * 	如果只有一句代码，那么在忽略"{}"号的同时，return关键字也要忽略
		 */
		Comparator<String> com = (o1, o2)-> o1.length()-o2.length();
		
		Collections.sort(list, com);
		System.out.println(list);
	}
}
