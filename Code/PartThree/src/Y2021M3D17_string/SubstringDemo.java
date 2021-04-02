package Y2021M3D17_string;
/**
 * String substring(int start, int end)
 * 截取指定范围内的字符串。两个参数为开始到结束的下标
 * 注:java api有一个特点，通常用两个数字表示范围时都是
 * “含头不含尾(左闭右开)”的
 * @author Grant·Vranes
 *
 */
public class SubstringDemo {
	public static void main(String[] args) {
		//			   0123456789
		String host = "www.baidu.com";
		System.out.println(host.substring(4, 9));//baidu
		
		//从参数开始截取到末尾
		System.out.println(host.substring(4));
		
	}
}
