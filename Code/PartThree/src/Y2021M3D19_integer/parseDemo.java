package Y2021M3D19_integer;
/**
 *	 包装类都提供了一个静态方法
 * 	parseXXX(String str)
 * 	可以将字符串解析为对应的基本类型，但是需要注意，该字符串
 * 	必须能够正确描述该基本类型可以保存的值，否则会抛出异常
 * 	例如：java.lang.NumberFormatException表示
 * 		字符串在转数字的时候格式不对
 * @author Grant·Vranes
 *
 */
public class parseDemo {
	public static void main(String[] args) {
		String str = "123";//123.123或者'a'都会报错，因为他要转换的类型不允许
		int d = Integer.parseInt(str);
		System.out.println(d);
		
		double dou = Double.parseDouble("123.123");
		System.out.println(dou);
	}
	
}
