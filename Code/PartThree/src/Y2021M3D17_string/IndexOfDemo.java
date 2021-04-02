package Y2021M3D17_string;
/**
 * int indexOf(String str)
 * 返回给定字符串在当前字符串中的位置，若当前
 * 字符串不包含该内容返回值为-1
 * @author Grant·Vranes
 *
 */
public class IndexOfDemo {
	public static void main(String[] args) {
		//			  0123456789
		String str = "thinking in java";
		int index = str.indexOf("in");
		System.out.println(index);//2
		//重载方法：方法名相同，方法参数不同
		//可以从指定位置开始查找
		index = str.indexOf("in",2);
		System.out.println(index);
		//查找最后一次出现的位置
		index = str.lastIndexOf("in");
		System.out.println(index);//9
		
		
	}
}
