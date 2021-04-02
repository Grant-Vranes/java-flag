package Y2021M3D17_string;
/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * 判断当前字符串是否是以给定字符串开始或结束的
 * @author Grant·Vranes
 *
 */
public class StartsWithDemo {
	public static void main(String[] args) {
		String str = "thing";
		
		boolean starts = str.startsWith("th");
		System.out.println(starts);//true
		
		boolean ends = str.endsWith("ing");
		System.out.println(ends);//true
		
		/*	这个可以应用在上传图片文件上，如果检测到你的后缀
		 * 	不是.jpg或者其他图片格式，就不允许上传
		 */
		
	}
}
