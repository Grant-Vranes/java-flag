package Y2021M3D17_string;
/**
 * String提供了一组重载的静态方法:valueOf
 * 可以将给定的内容转换为字符串
 * @author Grant·Vranes
 *
 */
public class ValueOfDemo {
	public static void main(String[] args) {
		int d = 1;
		String str = String.valueOf(d);
		System.out.println(str);
		
		str = d+"";//这种方法也可以转换成字符串，但偶尔用可以，正经的还是用valueOf()
		
	}
}
